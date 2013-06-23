package org.celllife.idart.integration.prehmis.builder


import org.celllife.idart.integration.prehmis.PrehmisGender
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType
import org.celllife.idart.domain.person.PersonBuilder

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

//        def envelope = getPatientResponse.data
        def envelope = getPatientResponse
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def patient = envelope.'soap:Body'.'prehmis:getPatientResponse'.result

        org.celllife.idart.domain.patient.PatientBuilder patientBuilder = new org.celllife.idart.domain.patient.PatientBuilder()
        PersonBuilder personBuilder = new PersonBuilder()

        String prehmisId = patient.id.text()
        if (prehmisId == null || prehmisId.isEmpty()) {
            return null
        }

        patientBuilder.addIdentifier(PrehmisPatientIdentifierType.PREHMIS.getSystem(), prehmisId)

        String pgwcPatientNumber = patient.pgwc_patient_number.text()
        if (pgwcPatientNumber != null && !pgwcPatientNumber.isEmpty()) {
            patientBuilder.addIdentifier(PrehmisPatientIdentifierType.PGWC.getSystem(), pgwcPatientNumber)
        }

        String saId = patient.sa_id_number.text()
        if (saId != null && !saId.isEmpty()) {
            personBuilder.addIdentifier(PrehmisPatientIdentifierType.SAID.getSystem(), saId)
        }

        String firstName = patient.first_name.text()
        if (firstName != null && !firstName.isEmpty()) {
            personBuilder.setFirstName(firstName)
        }

        String lastName = patient.last_name.text()
        if (lastName != null && !lastName.isEmpty()) {
            personBuilder.setLastName(lastName)
        }

        String dateOfBirth = patient.date_of_birth.text()
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            personBuilder.setBirthDate(new SimpleDateFormat(DATA_OF_BIRTH_FORMAT).parse(dateOfBirth))
        }
        String gender = patient.gender.text()
        if (gender != null && !gender.isEmpty()) {
            personBuilder.setGender(PrehmisGender.findByPrehmisCode(gender))
        }
        String mobileNumber = patient.cellphone_number.text()
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            personBuilder.setMobileNumber(mobileNumber)
        }

        patientBuilder.setPerson(personBuilder.build());
        patientBuilder.build()
    }
}
