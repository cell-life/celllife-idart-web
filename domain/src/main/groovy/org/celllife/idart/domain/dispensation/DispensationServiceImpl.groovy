package org.celllife.idart.domain.dispensation

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DispensationServiceImpl implements DispensationService {

    @Autowired DispensationRepository dispensationRepository

    @Autowired DispensationSequence dispensationSequence

    @Autowired DispensationValidator dispensationValidator

    @Override
    Dispensation save(Dispensation newDispensation) {

        dispensationValidator.validate(newDispensation)

        def existingDispensation = findByIdentifiers(newDispensation.identifiers)

        if (requiresIdartIdentifier(newDispensation, existingDispensation)) {
            newDispensation.addIdentifier(Dispensation.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingDispensation == null) {
            existingDispensation = new Dispensation()
        }

        existingDispensation.merge(newDispensation)

        dispensationRepository.save(existingDispensation)
    }

    @Override
    Dispensation findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingDispensation = dispensationRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingDispensation != null) {
                return existingDispensation
            }
        }

        null
    }

    @Override
    Dispensation findByIdentifier(String identifier) {
        dispensationRepository.findOneByIdentifier(Dispensation.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Dispensation> findAll() {
        dispensationRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", dispensationSequence.nextValue())
    }

    static requiresIdartIdentifier(Dispensation... dispensations) {

        for (Dispensation dispensation in dispensations) {
            if (dispensation?.hasIdentifierForSystem(Dispensation.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
