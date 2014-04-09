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
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.celllife.idart.client.dispensation.Dispensation;
import org.celllife.idart.client.encounter.Encounter;
import org.celllife.idart.client.part.Part;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Default implementation if IdartClient
 */
public final class IdartClientSingleton implements IdartClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdartClientSingleton.class);

    private static IdartClient instance;

    private final HttpClient httpClient;

    private final String authenticate;

    private final ObjectMapper objectMapper;

    private String idartWebUrl;

    public synchronized static IdartClient getInstance(String idartWebUrl, String idartWebUsername,
            String idartWebPassword) {

        if (instance == null) {
            instance = new IdartClientSingleton(idartWebUrl, idartWebUsername, idartWebPassword);
        }

        return instance;
    }

    private IdartClientSingleton(String idartWebUrl, String idartWebUsername, String idartWebPassword) {

        this.idartWebUrl = idartWebUrl;

        this.httpClient = new HttpClient();

        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(idartWebUsername, idartWebPassword);

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

        PostMethod postMethod = new PostMethod(url);

        postMethod.setRequestEntity(getStringRequestEntity(object));

        decorateMethodWithAuth(postMethod);
        decorateMethodWithContentType(postMethod);

        int status = executeMethod(postMethod);

        if (status != HttpStatus.SC_CREATED) {

            try {
                LOGGER.error(postMethod.getResponseBodyAsString());
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }

            throw new RuntimeException(status + " error occurred while trying to call POST on "+url);
        }
    }

    private void deleteToUrl(String url) {

        DeleteMethod deleteMethod = new DeleteMethod(url);

        decorateMethodWithAuth(deleteMethod);
        decorateMethodWithContentType(deleteMethod);

        int status = executeMethod(deleteMethod);

        if (status != HttpStatus.SC_OK) {

            try {
                LOGGER.error(deleteMethod.getResponseBodyAsString());
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }

            throw new RuntimeException(status+" error occurred while trying to call DELETE on "+url);
        }
    }

    private StringRequestEntity getStringRequestEntity(Object object) {

        try {
            String json = mapToJson(object);
            LOGGER.info("JSON being sent to the webservice " + json);
            return new StringRequestEntity(json, "application/json", "UTF-8");
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
