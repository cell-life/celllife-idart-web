package org.celllife.idart.integration.prehmis.builder
import org.celllife.idart.domain.doctor.Doctor
import org.celllife.idart.domain.doctor.DoctorIdentifierType
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 12h33
 */
class DoctorBuilder {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    static Set<Doctor> buildDoctors(getPractionerListResponse) {

        def envelope = getPractionerListResponse.data
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def doctors = []

        envelope.'soap:Body'.'prehmis:getPractitionerListResponse'.result.item.each { item ->

            def doctor = buildDoctor(item)
            if (doctor != null) {
                doctors << doctor
            }
        }

        doctors
    }

    static Doctor buildDoctor(prehmisDoctor) {

        org.celllife.idart.domain.doctor.DoctorBuilder builder = new org.celllife.idart.domain.doctor.DoctorBuilder()

        String prehmisPractitionerCode = prehmisDoctor.practitioner_code.text()
        if (prehmisPractitionerCode == null || prehmisPractitionerCode.isEmpty()) {
            return null
        }

        builder.addIdentifier(prehmisPractitionerCode, DoctorIdentifierType.PREHMIS)

        String firstName = prehmisDoctor.first_name.text()
        if (firstName != null && !firstName.isEmpty()) {
            builder.setFirstName(firstName)
        }

        String lastName = prehmisDoctor.last_name.text()
        if (lastName != null && !lastName.isEmpty()) {
            builder.setLastName(lastName)
        }

        builder.build()
    }
}
