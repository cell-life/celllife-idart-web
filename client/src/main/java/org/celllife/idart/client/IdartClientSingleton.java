package org.celllife.idart.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.BasicScheme;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.celllife.idart.client.encounter.Encounter;
import org.celllife.idart.client.part.Part;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.product.Product;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h22
 */
public final class IdartClientSingleton implements IdartClient {

    private static IdartClient instance;

    private final HttpClient httpClient;

    private final String authenticate;

    private final ObjectMapper objectMapper;

    private String idartWebUrl;

    public synchronized static IdartClient getInstance(String idartWebUrl, String idartWebUsername, String idartWebPassword) {

        if (instance == null) {
            instance = new IdartClientSingleton(idartWebUrl, idartWebUsername, idartWebPassword);
        }

        return instance;
    }

    private IdartClientSingleton(String idartWebUrl, String idartWebUsername, String idartWebPassword) {

        this.idartWebUrl = idartWebUrl;

        this.httpClient = new HttpClient();

        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials(idartWebUsername, idartWebPassword);

        this.authenticate = BasicScheme.authenticate(credentials, "US-ASCII");

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

    private void postToUrl(Object object, String url) {

        PostMethod postPart = new PostMethod(url);

        postPart.setRequestEntity(getStringRequestEntity(object));

        decorateMethodWithAuth(postPart);
        decorateMethodWithContentType(postPart);

        int status = executeMethod(postPart);

        if (status != HttpStatus.SC_CREATED) {
            throw new RuntimeException();
        }
    }

    private StringRequestEntity getStringRequestEntity(Object object) {

        try {
            return new StringRequestEntity(mapToJson(object), "application/json", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Patient> getPatients(String identifier) {

        String url = String.format("%s/patients/search/findByIdentifier?identifier=%s", idartWebUrl, identifier);
        GetMethod getPatients = new GetMethod(url);

        decorateMethodWithAuth(getPatients);
        decorateMethodWithAccept(getPatients);

        int status = executeMethod(getPatients);

        InputStream body = getResponseBodyAsString(getPatients);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonToPartyPatients(body);
    }

    @Override
    public List<Practitioner> getPractitioners() {

        GetMethod getPractitioners = new GetMethod(String.format("%s/practitioners", idartWebUrl));

        decorateMethodWithAuth(getPractitioners);
        decorateMethodWithAccept(getPractitioners);

        int status = executeMethod(getPractitioners);

        InputStream body = getResponseBodyAsString(getPractitioners);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonToPartyPractitioners(body);
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

    private InputStream getResponseBodyAsString(GetMethod getPatient) {
        try {
            return getPatient.getResponseBodyAsStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int executeMethod(HttpMethod httpMethod) {
        try {
            return httpClient.executeMethod(httpMethod);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void decorateMethodWithAuth(HttpMethod httpMethod) {

        httpMethod.setRequestHeader("Authorization", authenticate);
    }

    private static void decorateMethodWithAccept(HttpMethod httpMethod) {
        httpMethod.setRequestHeader("Accept", "application/json; charset=UTF-8");
    }

    private static void decorateMethodWithContentType(HttpMethod httpMethod) {
        httpMethod.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
    }
}
