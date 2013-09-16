package org.celllife.idart.integration.prehmis

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.application.prescription.PrescriptionNotSavedException
import org.celllife.idart.application.prescription.PrescriptionProvider
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.AuthorityId
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import java.text.SimpleDateFormat

import static org.celllife.idart.common.AuthorityId.PGWC
import static org.celllife.idart.common.AuthorityId.SA_IDENTITY_NUMBER
import static org.celllife.idart.common.AuthorityId.PREHMIS
import static org.celllife.idart.common.PartClassificationType.ATC
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.domain.part.PartClassificationApplications.getClassificationCode
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildApiLoginRequest
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildStorePrescriptionRequest

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h17
 */
@Service class PrehmisClinicPrescriptionProvider implements PrescriptionProvider {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    @Value('${prehmis.endpoint.url}')
    String prehmisEndpointUrl

    @Value('${prehmis.username}')
    String prehmisUsername

    @Value('${prehmis.password}')
    String prehmisPassword

    @Value('${prehmis.applicationKey}')
    String prehmisApplicationKey

    @Override
    void save(String facilityCode, PrescriptionDto prescription) {

        def prehmisRestClient = new RESTClient(prehmisEndpointUrl)

        def apiLoginRequest = buildApiLoginRequest([
                username: prehmisUsername,
                password: prehmisPassword,
                applicationKey: prehmisApplicationKey,
                facilityCode: facilityCode,
        ])

        try {
            prehmisRestClient.post(
                    body: apiLoginRequest,
                    contentType: ContentType.XML,
                    requestContentType: ContentType.XML,
                    headers: [
                            SOAPAction: "http://prehmis-qa.capetown.gov.za/apiLogin"
                    ]
            )
        } catch (Exception e) {
            throw new PrescriptionNotSavedException(e.message)
        }

        def storePrescriptionResponse

        try {
            storePrescriptionResponse = prehmisRestClient.post(
                    body: buildStorePrescriptionRequest(facilityCode, prescription),
                    contentType: ContentType.XML,
                    requestContentType: ContentType.XML,
                    headers: [
                            SOAPAction: "http://prehmis-qa.capetown.gov.za/storePrescription"
                    ]
            )
        } catch (Exception e) {
            throw new PrescriptionNotSavedException(e.message)
        }

        def envelope = storePrescriptionResponse.data

        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        String result = envelope.'soap:Body'.'prehmis:storePrescriptionResponse'.result

        if (!result.equals("Prescription saved")) {
            throw new PrescriptionNotSavedException(result)
        }
    }

    String buildStorePrescriptionRequest(String facilityCode, PrescriptionDto prescription) {

        def prehmisPrescription = [:]

        prescription.with {

            prehmisPrescription.id = getIdentifierValue(identifiers, AuthorityId.IDART)
            prehmisPrescription.patientSaIdNumber = getIdentifierValue(patient?.person?.identifiers, SA_IDENTITY_NUMBER)
            prehmisPrescription.prehmisPatientId = getIdentifierValue(patient?.identifiers, PREHMIS)
            prehmisPrescription.pgwcPatientNumber = getIdentifierValue(patient?.identifiers, PGWC)
            prehmisPrescription.practitionerCode = getIdentifierValue(prescriber?.identifiers, PREHMIS)
            prehmisPrescription.prescriptionDate = toPrehmisDate(dateWritten)

            if (prescribedMedications.size() != 0) {

                prehmisPrescription.duration = prescribedMedications[0]?.expectedSupplyDuration?.value
                prehmisPrescription.endDate = toPrehmisDate(prescribedMedications[0]?.valid?.thruDate)
                prehmisPrescription.changeReason = prescribedMedications[0]?.reasonForPrescribing

                prehmisPrescription.prescribedMedications = prescribedMedications.collect { prescribedMedication ->
                    [
                        atcCode : getClassificationCode(prescribedMedication.medication?.drug?.classifications, ATC),
                        amountPerTime : prescribedMedication.dosageInstruction?.doseQuantity?.value,
                        timesPerDay : prescribedMedication.dosageInstruction?.timing?.repeat?.frequency
                    ]
                }
            }
        }

        String storePrescriptionRequest = buildStorePrescriptionRequest([
                username: prehmisUsername,
                password: prehmisPassword,
                applicationKey: prehmisApplicationKey,
                facilityCode: facilityCode,
                prescription: prehmisPrescription
        ])

        storePrescriptionRequest
    }

    static toPrehmisDate(Date date) {

        if (date == null) {
            return null
        }

        new SimpleDateFormat("yyyy-MM-dd").format(date)
    }
}
