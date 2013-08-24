package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.practitioner.Practitioner

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 12h33
 */
class PractitionerBuilder {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    static Set<Practitioner> buildPractitioners(getPractionerListResponse) {

        def envelope = getPractionerListResponse.data
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        envelope.'soap:Body'.'prehmis:getPractitionerListResponse'.result.item
                .collect { buildPractitioner(it) }
                .findAll { it != null }
    }

    static Practitioner buildPractitioner(prehmisPractitioner) {

        Practitioner practitioner = new Practitioner()

        String prehmisPractitionerCode = prehmisPractitioner.practitioner_code.text()
        if (prehmisPractitionerCode == null || prehmisPractitionerCode.empty) {
            return null
        }

        practitioner.addId("http://prehmis.capetown.gov.za", prehmisPractitionerCode)

        Person person = new Person()

        String firstName = prehmisPractitioner.first_name.text()
        if (firstName != null && !firstName.empty) {
            person.firstName = firstName
        }

        String lastName = prehmisPractitioner.last_name.text()
        if (lastName != null && !lastName.empty) {
            person.lastName = lastName
        }

        practitioner.person = person

        practitioner
    }
}
