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

    static Patient buildIdartPatient(envelope) {

        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def prehmisPatient = envelope.'soap:Body'.'prehmis:getPatientResponse'.result

        Patient patient = new Patient()
        Person person = new Person()

        String prehmisId = prehmisPatient.id.text()
        if (prehmisId == null || prehmisId.empty) {
            return null
        }

        ((PartyRole) patient).addIdentifier(PrehmisPatientIdentifierType.PREHMIS.system, prehmisId)

        String pgwcPatientNumber = prehmisPatient.pgwc_patient_number.text()
        if (pgwcPatientNumber != null && !pgwcPatientNumber.empty) {
            ((PartyRole) patient).addIdentifier(PrehmisPatientIdentifierType.PGWC.system, pgwcPatientNumber)
        }

        String saId = prehmisPatient.sa_id_number.text()
        if (saId != null && !saId.empty) {
            ((Party) person).addIdentifier(PrehmisPatientIdentifierType.SAID.system, saId)
        }

        person.firstName = prehmisPatient.first_name.text()

        person.lastName = prehmisPatient.last_name.text()

        person.birthDate = getDate(prehmisPatient.date_of_birth.text())

        person.gender = PrehmisGender.findByPrehmisCode(prehmisPatient.gender.text())

        person.addMobileTelephoneNumber(getMobileTelephoneNumber(prehmisPatient.cellphone_number.text()))

        patient.setPerson(person)

        patient
    }

    private static Date getDate(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.empty) {
            return null
        }

        new SimpleDateFormat(DATA_OF_BIRTH_FORMAT).parse(dateOfBirth)
    }

    private static LinkedHashMap<String, String> getMobileTelephoneNumber(String mobileNumber) {

        if (mobileNumber == null || mobileNumber.trim().empty) {
            return null
        }

        mobileNumber.replaceAll(" ", "")

        // International Format
        if (mobileNumber.length().equals(11)) {
            return [countryCode: mobileNumber.substring(0, 2), contactNumber: "0" + mobileNumber.substring(2)]
        }

        return [countryCode: "27", contactNumber: mobileNumber]
    }
}
