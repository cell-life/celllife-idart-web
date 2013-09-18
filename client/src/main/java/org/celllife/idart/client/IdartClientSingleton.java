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
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.celllife.idart.client.clinic.Clinic;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.medication.Medication;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.part.Part;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;

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
    public void saveClinic(Clinic clinic) {

        PostMethod postClinic = new PostMethod(String.format("%s/clinics", idartWebUrl));

        postClinic.setRequestEntity(getStringRequestEntity(clinic));

        decorateMethodWithAuth(postClinic);
        decorateMethodWithContentType(postClinic);

        int status = executeMethod(postClinic);

        if (status != HttpStatus.SC_CREATED) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMedication(Medication medication) {

        PutMethod putMedication = new PutMethod(String.format("%s/medications", idartWebUrl));

        putMedication.setRequestEntity(getStringRequestEntity(medication));

        decorateMethodWithAuth(putMedication);
        decorateMethodWithContentType(putMedication);

        int status = executeMethod(putMedication);

        if (status != HttpStatus.SC_CREATED) {
            throw new RuntimeException();
        }

    }

    @Override
    public void savePrescription(Prescription prescription) {

        PostMethod postPrescription = new PostMethod(String.format("%s/prescriptions", idartWebUrl));

        postPrescription.setRequestEntity(getStringRequestEntity(prescription));

        decorateMethodWithAuth(postPrescription);
        decorateMethodWithContentType(postPrescription);

        int status = executeMethod(postPrescription);

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

    @Override
    public List<Compound> getCompounds() {

        GetMethod getRawMaterials = new GetMethod(String.format("%s/parts/search/findByType?type=COMPOUND", idartWebUrl));

        decorateMethodWithAuth(getRawMaterials);
        decorateMethodWithAccept(getRawMaterials);

        int status = executeMethod(getRawMaterials);

        InputStream body = getResponseBodyAsString(getRawMaterials);

        if (status != HttpStatus.SC_OK) {
             throw new RuntimeException("" + status);
        }

        return mapJsonToParts(body);
    }

    @Override
    public List<Drug> getDrugs() {

        GetMethod getDrugs = new GetMethod(String.format("%s/products/search/findByType?type=MEDICATION", idartWebUrl));

        decorateMethodWithAuth(getDrugs);
        decorateMethodWithAccept(getDrugs);

        int status = executeMethod(getDrugs);

        InputStream body = getResponseBodyAsString(getDrugs);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonToParts(body);
    }

    @Override
    public List<Form> getForms() {

        GetMethod getForms = new GetMethod(String.format("%s/forms", idartWebUrl));

        decorateMethodWithAuth(getForms);
        decorateMethodWithAccept(getForms);

        int status = executeMethod(getForms);

        InputStream body = getResponseBodyAsString(getForms);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonToForms(body);
    }

    @Override
    public List<UnitOfMeasure> getUnitsOfMeasure() {

        GetMethod getUnitsOfMeasure = new GetMethod(String.format("%s/unitsOfMeasure", idartWebUrl));

        decorateMethodWithAuth(getUnitsOfMeasure);
        decorateMethodWithAccept(getUnitsOfMeasure);

        int status = executeMethod(getUnitsOfMeasure);

        InputStream body = getResponseBodyAsString(getUnitsOfMeasure);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonTounitsOfMeasure(body);
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

    private <E extends Part> List<E> mapJsonToParts(InputStream json) {

        try {
            return objectMapper.reader(new TypeReference<List<Part>>() {
            }).readValue(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Form> mapJsonToForms(InputStream json) {

        try {
            return objectMapper.readValue(json, new TypeReference<List<Form>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<UnitOfMeasure> mapJsonTounitsOfMeasure(InputStream json) {

        try {
            return objectMapper.readValue(json, new TypeReference<List<UnitOfMeasure>>() {
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
