package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType
import org.junit.Assert
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h36
 */
class GetPatientRequestBuilderTest {

    @Test
    void testBuild() throws Exception {

        String getPatientRequest = new GetPatientRequestBuilder()
                .setUsername("idartUsername")
                .setPassword("idartPassword")
                .setApplicationKey("idartApplicationKey")
                .setFacilityCode("idartFacilityCode")
                .setPatientIdentifierValue("patientIdentifierValue")
                .setPatientIdentifierType(PrehmisPatientIdentifierType.PREHMIS)
                .build()

        Assert.assertNotNull(getPatientRequest)

    }
}
