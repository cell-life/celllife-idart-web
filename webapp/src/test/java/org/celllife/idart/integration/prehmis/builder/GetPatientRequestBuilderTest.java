package org.celllife.idart.integration.prehmis.builder;

import org.celllife.idart.domain.patient.PatientIdentifierType;
import org.junit.Test;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h36
 */
public class GetPatientRequestBuilderTest {

    @Test
    public void testBuild() throws Exception {

        String getPatientRequest = new GetPatientRequestBuilder()
                .setUsername("idartUsername")
                .setPassword("idartPassword")
                .setApplicationKey("idartApplicationKey")
                .setFacilityCode("idartFacilityCode")
                .setPatientIdentifierValue("patientIdentifierValue")
                .setPatientIdentifierType(PatientIdentifierType.PREHMIS)
                .build();

        System.out.println(getPatientRequest);

    }
}
