package org.celllife.idart.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.BasicScheme;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.celllife.idart.client.clinic.Clinic;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.*;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h22
 */
public final class IdartClientSingleton implements IdartClient {

    private static IdartClient instance;

    private final HttpClient httpClient;

    private final String authenticate;

    private final ObjectMapper objectMapper;

    public final static Object LOCK = new Object();

    public static String idartWebUsername;

    public static String idartWebPassword;

    public static String idartWebUrl;

    public static String idartApplicationId;

    public synchronized static IdartClient getInstance() {

        if (instance == null) {
            instance = new IdartClientSingleton();
        }

        return instance;
    }

    private IdartClientSingleton() {

        httpClient = new HttpClient();

        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials(idartWebUsername, idartWebPassword);

        authenticate = BasicScheme.authenticate(credentials, "US-ASCII");

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public void saveClinic(Clinic clinic) {

        PostMethod postClinic = new PostMethod(
                String.format(
                        "%s/clinics",
                        idartWebUrl
                )
        );

        postClinic.setRequestEntity(getStringRequestEntity(clinic));

        decorateMethodWithAuth(postClinic);
        decorateMethodWithContentType(postClinic);

        int status = executeMethod(postClinic);

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
    public List<PartyRole> getPatients(String clinicName, String patientIdentifierValue) {

        GetMethod getPatients = new GetMethod(
                String.format(
                        "%s/clinics/%s/patients/search/findByIdentifier?patientIdentifier=%s",
                        idartWebUrl,
                        clinicName,
                        patientIdentifierValue
                )
        );

        decorateMethodWithAuth(getPatients);
        decorateMethodWithAccept(getPatients);

        int status = executeMethod(getPatients);

        InputStream body = getResponseBodyAsString(getPatients);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonToPartyRoles(body);
    }

    @Override
    public List<PartyRole> getPractitioners(String clinicName) {

        GetMethod getPractitioners = new GetMethod(
                String.format(
                        "%s/clinics/%s/practitioners",
                        idartWebUrl,
                        clinicName
                )
        );

        decorateMethodWithAuth(getPractitioners);
        decorateMethodWithAccept(getPractitioners);

        int status = executeMethod(getPractitioners);

        InputStream body = getResponseBodyAsString(getPractitioners);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonToPartyRoles(body);
    }

    @Override
    public List<Compound> getCompounds() {
        GetMethod getRawMaterials = new GetMethod(
                String.format(
                        "%s/compounds",
                        idartWebUrl
                )
        );

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
    public List<Drug> getDrugs(String clinicName) {
        GetMethod getFinishedGoods = new GetMethod(
                String.format(
                        "%s/clinics/%s/drugs",
                        idartWebUrl,
                        clinicName
                )
        );

        decorateMethodWithAuth(getFinishedGoods);
        decorateMethodWithAccept(getFinishedGoods);

        int status = executeMethod(getFinishedGoods);

        InputStream body = getResponseBodyAsString(getFinishedGoods);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonToParts(body);
    }

    @Override
    public List<Form> getForms() {
        GetMethod getForms = new GetMethod(
                String.format(
                        "%s/forms",
                        idartWebUrl
                )
        );

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
        GetMethod getUnitsOfMeasure = new GetMethod(
                String.format(
                        "%s/unitsOfMeasure",
                        idartWebUrl
                )
        );

        decorateMethodWithAuth(getUnitsOfMeasure);
        decorateMethodWithAccept(getUnitsOfMeasure);

        int status = executeMethod(getUnitsOfMeasure);

        InputStream body = getResponseBodyAsString(getUnitsOfMeasure);

        if (status != HttpStatus.SC_OK) {
            throw new RuntimeException("" + status);
        }

        return mapJsonTounitsOfMeasure(body);
    }

    private List<PartyRole> mapJsonToPartyRoles(InputStream json) {

        try {
            return objectMapper.readValue(json, new TypeReference<List<PartyRole>>() {
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

    private String mapToJson(Object object) {

        try {
            return objectMapper.writeValueAsString(object);
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
        httpMethod.setRequestHeader("X-IDART_APPLICATION_ID", idartApplicationId);
    }

    private static void decorateMethodWithAccept(HttpMethod httpMethod) {
        httpMethod.setRequestHeader("Accept", "application/json; charset=UTF-8");
    }

    private static void decorateMethodWithContentType(HttpMethod httpMethod) {
        httpMethod.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
    }
}