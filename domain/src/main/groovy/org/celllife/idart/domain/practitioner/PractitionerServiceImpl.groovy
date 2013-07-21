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

    @Autowired PractitionerRepository practitionerRepository

    @Autowired PractitionerSequence practitionerSequence

    @Override
    Practitioner findByIdentifiers(Iterable<Identifier> identifiers) {

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
            ((PartyRole) newPractitioner).addIdentifier(Practitioner.IDART_SYSTEM, nextPractitionerIdentifier())
        }

        if (existingPractitioner == null) {
            existingPractitioner = new Practitioner()
        }

        existingPractitioner.merge(newPractitioner)

        practitionerRepository.save(existingPractitioner)
    }

    @Override
    Practitioner findByIdentifier(String identifier) {
        practitionerRepository.findOneByIdentifier(Practitioner.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Practitioner> findAll() {
        practitionerRepository.findAll()
    }

    private String nextPractitionerIdentifier() {
        String.format(IDART_PRACTITIONER_IDENTIFIER_FORMAT, practitionerSequence.nextValue())
    }
}
