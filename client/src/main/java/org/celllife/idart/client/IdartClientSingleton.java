package org.celllife.idart.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.ProxySelector;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.celllife.idart.client.dispensation.Dispensation;
import org.celllife.idart.client.encounter.Encounter;
import org.celllife.idart.client.part.Part;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Default implementation if IdartClient
 */
public final class IdartClientSingleton implements IdartClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdartClientSingleton.class);

    private static IdartClient instance;

    private final CloseableHttpClient httpClient;

    private final ObjectMapper objectMapper;

    private String idartWebUrl;
    
    private static boolean useProxy = false;

    public synchronized static IdartClient getInstance(String idartWebUrl, String idartWebUsername, String idartWebPassword) {

        if (instance == null || useProxy) {
            instance = new IdartClientSingleton(idartWebUrl, idartWebUsername, idartWebPassword, 
                    null, null, null, null, null);
        }

        return instance;
    }

    public synchronized static IdartClient getInstance(String idartWebUrl, String idartWebUsername, String idartWebPassword, 
            String proxyUrl, Integer proxyPort, String proxyUser, String proxyPassword, String proxyDomain) {

        if (instance == null || !useProxy) {
            instance = new IdartClientSingleton(idartWebUrl, idartWebUsername, idartWebPassword, 
                    proxyUrl, proxyPort, proxyUser, proxyPassword, proxyDomain);
        }

        return instance;
    }

    private IdartClientSingleton(String idartWebUrl, String idartWebUsername, String idartWebPassword,
            final String proxyUrl, final Integer proxyPort, 
            final String proxyUser, final String proxyPassword, final String proxyDomain) {

        this.idartWebUrl = idartWebUrl;
        
        // add authentication
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(idartWebUsername, idartWebPassword);
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        String idartWebHost;
        try {
            URL idartWebURL = new URL(idartWebUrl);
            idartWebHost = idartWebURL.getHost();
        } catch (MalformedURLException e) {
            LOGGER.error("Terrible problem - idartwebUrl '" + idartWebUrl + "' is malformed. ", e);
            idartWebHost = AuthScope.ANY_HOST;
        }
        AuthScope authScope = new AuthScope(idartWebHost, AuthScope.ANY_PORT);
        credentialsProvider.setCredentials(authScope, credentials);
        
        LOGGER.info("PROXY: " + proxyUrl + ":" + proxyPort + " " + proxyUser + " " + proxyDomain);
        if (proxyUrl != null && !proxyUrl.trim().isEmpty()) {
            LOGGER.info("Creating iDARTweb client with proxy server");
            
            useProxy = true;
            if (proxyUser != null && !proxyUser.trim().isEmpty()) {
                // add authentication (assuming NTLM)
                String workstation = null;
                try {
                    workstation = InetAddress.getLocalHost().getHostName();
                } catch (UnknownHostException e) {
                    LOGGER.error("Could not determine local host name", e);
                }
                LOGGER.info("Adding NTLM Credentials for workstation "+workstation);
                NTCredentials proxyCredentials = new NTCredentials(proxyUser, proxyPassword, workstation, proxyDomain);
                credentialsProvider.setCredentials(
                        new AuthScope(proxyUrl, proxyPort, AuthScope.ANY_REALM, AuthSchemes.NTLM), 
                        proxyCredentials);
            }

            // create http client
            HttpHost proxy = new HttpHost(proxyUrl, proxyPort);
            this.httpClient = HttpClients
                    .custom()
                    .useSystemProperties()
                    .setDefaultCredentialsProvider(credentialsProvider)
                    .setProxy(proxy)
                    .setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy())
                    .build();
        } else {
            LOGGER.info("Creating (default) proxy aware iDARTweb client");
            
            useProxy = false; // we aren't manually specifying the proxy (as above)

            // add default proxy-aware
            SystemDefaultRoutePlanner routePlanner = new SystemDefaultRoutePlanner(ProxySelector.getDefault());
            
            // add some authentication (note: for NTLM, include the domain in the username like DOMAIN\\USERNAME)
            final String systemProxyUser = System.getProperty("http.proxyUser");
            final String systemProxyPassword = System.getProperty("http.proxyPassword");
            if (systemProxyUser != null && !systemProxyUser.trim().isEmpty() 
                    && systemProxyPassword != null && !systemProxyPassword.trim().isEmpty()) {
                LOGGER.info("Adding default proxy authentication for "+systemProxyUser);
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(systemProxyUser, systemProxyPassword.toCharArray());
                    }
                });
            }
            
            // create http client
            this.httpClient = HttpClients
                    .custom()
                    .useSystemProperties()
                    .setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy())
                    .setDefaultCredentialsProvider(credentialsProvider)
                    .setRoutePlanner(routePlanner)
                    .build();
        }
        
        this.objectMapper = new ObjectMapper();

        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public void saveEncounter(Encounter encounter) {

        postToUrl(encounter, String.format("%s/encounters", idartWebUrl));
    }

    @Override
    public void savePart(Part part) {

        postToUrl(part, String.format("%s/parts", idartWebUrl));
    }

    @Override
    public void saveProduct(Product product) {

        postToUrl(product, String.format("%s/products", idartWebUrl));
    }

    @Override
    public void savePrescription(Prescription prescription) {

        postToUrl(prescription, String.format("%s/prescriptions", idartWebUrl));
    }

    @Override
    public void deletePrescription(Prescription prescription) {
        String prescriptionId = prescription.getFirstIdentifier();
        String url = String.format("%s/prescriptions/deleteByIdentifier?identifier=%s", idartWebUrl, prescriptionId);
        deleteToUrl(url);
    }

    @Override
    public void saveDispensation(Dispensation dispensation) {

        postToUrl(dispensation, String.format("%s/dispensations", idartWebUrl));
    }

    @Override
    public void deleteDispensation(Dispensation dispensation) {
        String dispensationId = dispensation.getFirstIdentifier();
        deleteToUrl(String.format("%s/dispensations/deleteByIdentifier?identifier=%s", idartWebUrl, dispensationId));
    }

    private void postToUrl(Object object, String url) {

        HttpPost HttpPost = new HttpPost(url);
        try {
            HttpPost.setEntity(getStringEntity(object));
    
            decorateMethodWithContentType(HttpPost);
    
            HttpResponse response = executeMethod(HttpPost);
            int status = response.getStatusLine().getStatusCode();
            response.getEntity();
    
            if (status != HttpStatus.SC_CREATED) {
    
                try {
                    LOGGER.error(getResponseBodyAsString(response));
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
    
                throw new RuntimeException(status + " error occurred while trying to call POST on "+url);
            }
        } finally {
            HttpPost.releaseConnection();
        }
    }

    private void deleteToUrl(String url) {

        HttpDelete HttpDelete = new HttpDelete(url);

        try {
            decorateMethodWithContentType(HttpDelete);
    
            HttpResponse response = executeMethod(HttpDelete);
            int status = response.getStatusLine().getStatusCode();
    
            if (status != HttpStatus.SC_OK) {
                try {
                    LOGGER.error(getResponseBodyAsString(response));
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
                throw new RuntimeException(status+" error occurred while trying to call DELETE on "+url);
            }
        } finally {
            HttpDelete.releaseConnection();
        }
    }

    private StringEntity getStringEntity(Object object) {
        String json = mapToJson(object);
        LOGGER.info("JSON being sent to the webservice " + json);
        return new StringEntity(json, ContentType.APPLICATION_JSON);
    }

    @Override
    public List<Patient> getPatients(String identifier) {

        String url = String.format("%s/patients/search/findByIdentifier?identifier=%s", idartWebUrl, identifier);
        HttpGet getPatients = new HttpGet(url);

        try {
            decorateMethodWithAccept(getPatients);
    
            HttpResponse response = executeMethod(getPatients);
    
            int status = response.getStatusLine().getStatusCode();
            if (status != HttpStatus.SC_OK) {
                throw new RuntimeException("" + status);
            }
    
            InputStream body = getResponseBodyAsInputStream(response);
    
            return mapJsonToPartyPatients(body);
        } finally {
            getPatients.releaseConnection();
        }
    }

    @Override
    public List<Practitioner> getPractitioners() {

        HttpGet getPractitioners = new HttpGet(String.format("%s/practitioners", idartWebUrl));
        
        try {
            decorateMethodWithAccept(getPractitioners);
    
            HttpResponse response = executeMethod(getPractitioners);
            int status = response.getStatusLine().getStatusCode();
    
            InputStream body = getResponseBodyAsInputStream(response);
    
            if (status != HttpStatus.SC_OK) {
                throw new RuntimeException("" + status);
            }
    
            return mapJsonToPartyPractitioners(body);
        } finally {
            getPractitioners.releaseConnection();
        }
    }

    private List<Patient> mapJsonToPartyPatients(InputStream json) {

        try {
            return objectMapper.readValue(json, new TypeReference<List<Patient>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Practitioner> mapJsonToPartyPractitioners(InputStream json) {

        try {
            return objectMapper.readValue(json, new TypeReference<List<Practitioner>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String mapToJson(Object object) {

        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private InputStream getResponseBodyAsInputStream(HttpResponse httpResponse) {
        InputStream in = null;
        try {
            in = httpResponse.getEntity().getContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return in;
    }

    private String getResponseBodyAsString(HttpResponse httpResponse) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();

        InputStream in = httpResponse.getEntity().getContent();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        try {
            String line = bufferedReader.readLine();
            while(line != null){
                inputStringBuilder.append(line);inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return inputStringBuilder.toString();
    }

    private HttpResponse executeMethod(HttpRequestBase httpMethod) {
        try {
            return httpClient.execute(httpMethod);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void decorateMethodWithAccept(HttpRequestBase httpMethod) {
        httpMethod.setHeader("Accept", "application/json; charset=UTF-8");
    }

    private static void decorateMethodWithContentType(HttpRequestBase httpMethod) {
        httpMethod.setHeader("Content-Type", "application/json; charset=UTF-8");
    }
}
