package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.partyrole.PartyRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.celllife.idart.domain.practitioner.Practitioners.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h47
 */
@Service class PractitionerServiceImpl implements PractitionerService {

    static final String IDART_PRACTITIONER_IDENTIFIER_SYSTEM = "http://www.cell-life.org/idart/practitioners"

    @Autowired PractitionerRepository practitionerRepository

    @Autowired PractitionerSequence practitionerSequence

    @Override
    Practitioner findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {
            Practitioner practitioner = practitionerRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (practitioner != null) {
                return practitioner
            }
        }

        null
    }

    @Override
    Practitioner save(Practitioner newPractitioner) {

        Practitioner existingPractitioner = findByIdentifiers(newPractitioner.identifiers)

        if (requiresIdartIdentifier(newPractitioner, existingPractitioner)) {
            ((PartyRole) newPractitioner).addIdentifier(IDART_PRACTITIONER_IDENTIFIER_SYSTEM, nextPractitionerIdentifier())
        }

        if (existingPractitioner != null) {
            existingPractitioner.merge(newPractitioner)
            return practitionerRepository.save(existingPractitioner)
        }

        return practitionerRepository.save(newPractitioner)
    }

    @Override
    Practitioner findByIdentifier(String identifier) {
        practitionerRepository.findOneByIdentifier(IDART_PRACTITIONER_IDENTIFIER_SYSTEM, identifier)
    }

    @Override
    Iterable<Practitioner> findAll() {
        practitionerRepository.findAll()
    }

    private String nextPractitionerIdentifier() {
        String.format("%08d", practitionerSequence.nextValue())
    }
}
