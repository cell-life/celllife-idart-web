package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber
import org.celllife.idart.integration.prehmis.PrehmisGender

import java.text.SimpleDateFormat

import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 12h33
 */
class PatientBuilder {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    static final DATA_OF_BIRTH_FORMAT = 'yyyy-MM-dd'

    static PatientDto buildIdartPatient(envelope) {

        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def prehmisPatient = envelope.'soap:Body'.'prehmis:getPatientResponse'.result

        PatientDto patient = new PatientDto()
        PersonDto person = new PersonDto()

        String prehmisId = prehmisPatient.id.text()
        if (prehmisId == null || prehmisId.empty) {
            return null
        }

        patient.identifiers << newIdentifier(AuthorityId.PREHMIS, prehmisId)

        String pgwcPatientNumber = prehmisPatient.pgwc_patient_number.text()
        if (pgwcPatientNumber != null && !pgwcPatientNumber.empty) {
            patient.identifiers << newIdentifier(AuthorityId.PGWC, pgwcPatientNumber)
        }

        String saId = prehmisPatient.sa_id_number.text()
        if (saId != null && !saId.empty) {
            patient.identifiers << newIdentifier(AuthorityId.SAID, saId)
        }

        person.firstName = prehmisPatient.first_name.text()

        person.lastName = prehmisPatient.last_name.text()

        person.birthDate = getDate(prehmisPatient.date_of_birth.text())

        person.gender = PrehmisGender.findByPrehmisCode(prehmisPatient.gender.text())

        person.addContactMechanism(getMobileTelephoneNumber(prehmisPatient.cellphone_number.text()))

        patient.person = person

        patient
    }

    static Date getDate(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.empty) {
            return null
        }

        new SimpleDateFormat(DATA_OF_BIRTH_FORMAT).parse(dateOfBirth)
    }

    static MobileTelephoneNumber getMobileTelephoneNumber(String mobileNumber) {

        if (mobileNumber == null || mobileNumber.trim().empty) {
            return null
        }

        mobileNumber.replaceAll(" ", "")

        // International Format
        if (mobileNumber.length().equals(11)) {
            return [countryCode: mobileNumber.substring(0, 2), contactNumber: "0" + mobileNumber.substring(2)]
        }

        return new MobileTelephoneNumber(countryCode: "27", contactNumber: mobileNumber)
    }
}
