package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PractitionerServiceImpl implements PractitionerService {

    @Autowired PractitionerRepository practitionerRepository

    @Autowired PractitionerSequence practitionerSequence

    @Autowired PractitionerValidator practitionerValidator

    @Override
    Practitioner save(Practitioner newPractitioner) {

        practitionerValidator.validate(newPractitioner)

        def existingPractitioner = findByIdentifiers(newPractitioner.identifiers)

        if (requiresIdartIdentifier(newPractitioner, existingPractitioner)) {
            newPractitioner.addIdentifier(Practitioner.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingPractitioner == null) {
            existingPractitioner = new Practitioner()
        }

        existingPractitioner.merge(newPractitioner)

        practitionerRepository.save(existingPractitioner)
    }

    @Override
    Practitioner findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingPractitioner = practitionerRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingPractitioner != null) {
                return existingPractitioner
            }
        }

        null
    }

    @Override
    Practitioner findByIdentifier(String identifier) {
        practitionerRepository.findOneByIdentifier(Practitioner.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Practitioner> findAll() {
        practitionerRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", practitionerSequence.nextValue())
    }

    static requiresIdartIdentifier(Practitioner... practitioners) {

        for (Practitioner practitioner in practitioners) {
            if (practitioner?.hasIdentifierForSystem(Practitioner.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
