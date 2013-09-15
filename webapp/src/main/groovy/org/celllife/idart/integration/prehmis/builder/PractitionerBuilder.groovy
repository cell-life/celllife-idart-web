package org.celllife.idart.integration.prehmis.builder

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.integration.prehmis.PrehmisPractitionerType

import static org.celllife.idart.common.AuthorityId.PREHMIS
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 12h33
 */
class PractitionerBuilder {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    static Set<PractitionerDto> buildPractitioners(getPractionerListResponse) {

        def envelope = getPractionerListResponse.data
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        def practitioners = envelope.'soap:Body'.'prehmis:getPractitionerListResponse'.result.item
                .collect { buildPractitioner(it) }

        def result = practitioners.findAll { it != null }

        result
    }

    static PractitionerDto buildPractitioner(prehmisPractitioner) {

        PractitionerDto practitioner = new PractitionerDto()

        String prehmisPractitionerCode = prehmisPractitioner.practitioner_code.text()
        if (prehmisPractitionerCode == null || prehmisPractitionerCode.empty) {
            return null
        }

        String prehmisPractitionerType = prehmisPractitioner.practitioner_type.text()
        if (prehmisPractitionerType != null && !prehmisPractitionerType.empty) {
            practitioner.type = PrehmisPractitionerType.getPractitionerType(prehmisPractitionerType)
        }

        practitioner.identifiers = [newIdentifier(PREHMIS, prehmisPractitionerCode)] as Set

        PersonDto person = new PersonDto()

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
