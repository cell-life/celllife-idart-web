package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.domain.party.Party
import org.celllife.idart.domain.partyrole.PartyRole
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.person.Person
import org.celllife.idart.integration.prehmis.PrehmisGender
import org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType

import java.text.SimpleDateFormat

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 12h33
 */
class PatientBuilder {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    static final DATA_OF_BIRTH_FORMAT = 'yyyy-MM-dd'

    static Patient buildIdartPatient(getPatientResponse) {

        def envelope = getPatientResponse.data
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def prehmisPatient = envelope.'soap:Body'.'prehmis:getPatientResponse'.result

        Patient patient = new Patient()
        Person person = new Person()

        String prehmisId = prehmisPatient.id.text()
        if (prehmisId == null || prehmisId.isEmpty()) {
            return null
        }

        ((PartyRole) patient).addIdentifier(PrehmisPatientIdentifierType.PREHMIS.getSystem(), prehmisId)

        String pgwcPatientNumber = prehmisPatient.pgwc_patient_number.text()
        if (pgwcPatientNumber != null && !pgwcPatientNumber.isEmpty()) {
            ((PartyRole) patient).addIdentifier(PrehmisPatientIdentifierType.PGWC.getSystem(), pgwcPatientNumber)
        }

        String saId = prehmisPatient.sa_id_number.text()
        if (saId != null && !saId.isEmpty()) {
            ((Party) person).addIdentifier(PrehmisPatientIdentifierType.SAID.getSystem(), saId)
        }

        String firstName = prehmisPatient.first_name.text()
        if (firstName != null && !firstName.isEmpty()) {
            person.setFirstName(firstName)
        }

        String lastName = prehmisPatient.last_name.text()
        if (lastName != null && !lastName.isEmpty()) {
            person.setLastName(lastName)
        }

        String dateOfBirth = prehmisPatient.date_of_birth.text()
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            person.setBirthDate(new SimpleDateFormat(DATA_OF_BIRTH_FORMAT).parse(dateOfBirth))
        }
        String gender = prehmisPatient.gender.text()
        if (gender != null && !gender.isEmpty()) {
            person.setGender(PrehmisGender.findByPrehmisCode(gender))
        }
        String mobileNumber = prehmisPatient.cellphone_number.text()
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
//            Contact Details
//            person.setMobileNumber(mobileNumber)
        }

        patient.setPerson(person)

        patient
    }
}
