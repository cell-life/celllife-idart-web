package org.celllife.idart.integration.prehmis.builder

import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-28
 * Time: 13h24
 */
class StorePrescriptionRequestBuilderTest {

    @Test
    public void shouldBuildStorePrescriptionRequest() throws Exception {

        def model = [
                xmlnsPreh: "http://prehmis-qa.capetown.gov.za/",
                username: "idartUsername",
                password: "idartPassword",
                applicationKey: "idartApplicationKey",
                facilityCode: "idartFacilityCode",
                prescription: [
                        id: "id",
                        pgwcPatientNumber: "pgwcPatientNumber",
                        patientSaIdNumber: "patientSaIdNumber",
                        practitionerCode: "practitionerCode",
                        prescriptionDate: "prescriptionDate",
                        duration: "duration",
                        endDate: "endDate",
                        changeReason: "changeReason",
                        prescribedMedications: [
                                [
                                        atcCode: "atcCode",
                                        amountPerTime: "amountPerTime",
                                        timesPerDay: "timesPerDay"
                                ],
                                [
                                        atcCode: "atcCode",
                                        amountPerTime: "amountPerTime",
                                        timesPerDay: "timesPerDay"
                                ]
                        ]
                ]
        ]

        println PrehmisRequestBuilder.buildStorePrescriptionRequest(model)

    }
}
