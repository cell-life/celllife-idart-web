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

        String getPatientRequest = PrehmisRequestBuilder.buildGetPatientRequest(
                username: "idartUsername",
                password: "idartPassword",
                applicationKey: "idartApplicationKey",
                facilityCode: "idartFacilityCode",
                patientIdValue: "patientIdValue",
                patientIdType: PrehmisPatientIdentifierType.PREHMIS
        )

        Assert.assertNotNull(getPatientRequest)
    }
}
