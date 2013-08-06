package org.celllife.idart.domain.drug

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DrugServiceImpl implements DrugService {

    @Autowired DrugRepository drugRepository

    @Autowired DrugSequence drugSequence

    @Autowired DrugValidator drugValidator

    @Override
    Drug save(Drug newDrug) {

        drugValidator.validate(newDrug)

        def existingDrug = findByIdentifiers(newDrug.identifiers)

        if (requiresIdartIdentifier(newDrug, existingDrug)) {
            newDrug.addIdentifier(Drug.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingDrug == null) {
            existingDrug = new Drug()
        }

        existingDrug.merge(newDrug)

        drugRepository.save(existingDrug)
    }

    @Override
    Drug findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingDrug = drugRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingDrug != null) {
                return existingDrug
            }
        }

        null
    }

    @Override
    Drug findByIdentifier(String identifier) {
        drugRepository.findOneByIdentifier(Drug.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Drug> findAll() {
        drugRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", drugSequence.nextValue())
    }

    static requiresIdartIdentifier(Drug... drugs) {

        for (Drug drug in drugs) {
            if (drug?.hasIdentifierForSystem(Drug.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
