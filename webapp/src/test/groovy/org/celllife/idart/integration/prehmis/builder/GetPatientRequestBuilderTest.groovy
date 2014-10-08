package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType
import org.junit.Assert
import org.junit.Test


class GetPatientRequestBuilderTest {

    @Test
    void testBuild() throws Exception {

        String getPatientRequest = PrehmisRequestBuilder.buildGetPatientRequest(
                xmlnsPreh: "http://prehmis-qa.capetown.gov.za/",
                username: "idartUsername",
                password: "idartPassword",
                applicationKey: "idartApplicationKey",
                facilityCode: "idartFacilityCode",
                patientIdentifierValue: "patientIdentifierValue",
                patientIdentifierType: PrehmisPatientIdentifierType.PREHMIS
        )

        Assert.assertNotNull(getPatientRequest)
    }
}
