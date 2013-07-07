package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.concept.Identifier
import org.dozer.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h47
 */
@Service class PractitionerServiceImpl implements PractitionerService {

    @Autowired PractitionerRepository practitionerRepository

    @Autowired Mapper mapper

    @Override
    Practitioner findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {
            Practitioner practitioner = practitionerRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (practitioner != null) {
                return practitioner
            }
        }

        null
    }

    @Override
    Practitioner save(Practitioner newPractitioner) {

        Practitioner existingPractitioner = findByIdentifiers(newPractitioner.getIdentifiers())

        if (existingPractitioner != null) {
            mapper.map(newPractitioner, existingPractitioner)
            return practitionerRepository.save(existingPractitioner)
        }

        return practitionerRepository.save(newPractitioner)
    }
}
