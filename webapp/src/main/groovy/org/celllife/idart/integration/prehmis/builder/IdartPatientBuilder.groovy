package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientBuilder
import org.celllife.idart.integration.prehmis.PrehmisGender
import org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType

import java.text.SimpleDateFormat

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 12h33
 */
class IdartPatientBuilder {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    static final DATA_OF_BIRTH_FORMAT = 'yyyy-MM-dd'

    static Patient buildIdartPatient(getPatientResponse) {

        def envelope = getPatientResponse.data
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def patient = envelope.'soap:Body'.'prehmis:getPatientResponse'.result

        PatientBuilder builder = new PatientBuilder()

        String prehmisId = patient.id.text()
        if (prehmisId == null || prehmisId.isEmpty()) {
            return null
        }

        builder.addIdentifier(prehmisId, PrehmisPatientIdentifierType.PREHMIS.getIdartType())

        String pgwcPatientNumber = patient.pgwc_patient_number.text()
        if (pgwcPatientNumber != null && !pgwcPatientNumber.isEmpty()) {
            builder.addIdentifier(pgwcPatientNumber, PrehmisPatientIdentifierType.PGWC.getIdartType())
        }

        String saId = patient.sa_id_number.text()
        if (saId != null && !saId.isEmpty()) {
            builder.addIdentifier(saId, PrehmisPatientIdentifierType.SAID.getIdartType())
        }

        String firstName = patient.first_name.text()
        if (firstName != null && !firstName.isEmpty()) {
            builder.setFirstName(firstName)
        }

        String lastName = patient.last_name.text()
        if (lastName != null && !lastName.isEmpty()) {
            builder.setLastName(lastName)
        }

        String dateOfBirth = patient.date_of_birth.text()
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            builder.setDataOfBirth(new SimpleDateFormat(DATA_OF_BIRTH_FORMAT).parse(dateOfBirth))
        }
        String gender = patient.gender.text()
        if (gender != null && !gender.isEmpty()) {
            builder.setGender(PrehmisGender.findByPrehmisCode(gender))
        }
        String mobileNumber = patient.cellphone_number.text()
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            builder.setMobileNumber(mobileNumber)
        }

        builder.build()
    }
}
