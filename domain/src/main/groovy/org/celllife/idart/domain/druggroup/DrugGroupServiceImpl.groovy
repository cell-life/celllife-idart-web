package org.celllife.idart.domain.druggroup

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DrugGroupServiceImpl implements DrugGroupService {

    @Autowired DrugGroupRepository drugGroupRepository

    @Autowired DrugGroupSequence drugGroupSequence

    @Autowired DrugGroupValidator drugGroupValidator

    @Override
    DrugGroup save(DrugGroup newDrugGroup) {

        drugGroupValidator.validate(newDrugGroup)

        def existingDrugGroup = findByIdentifiers(newDrugGroup.identifiers)

        if (requiresIdartIdentifier(newDrugGroup, existingDrugGroup)) {
            newDrugGroup.addIdentifier(DrugGroup.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingDrugGroup == null) {
            existingDrugGroup = new DrugGroup()
        }

        existingDrugGroup.merge(newDrugGroup)

        drugGroupRepository.save(existingDrugGroup)
    }

    @Override
    DrugGroup findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingDrugGroup = drugGroupRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingDrugGroup != null) {
                return existingDrugGroup
            }
        }

        null
    }

    @Override
    DrugGroup findByIdentifier(String identifier) {
        drugGroupRepository.findOneByIdentifier(DrugGroup.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<DrugGroup> findAll() {
        drugGroupRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", drugGroupSequence.nextValue())
    }

    static requiresIdartIdentifier(DrugGroup... drugGroups) {

        for (DrugGroup drugGroup in drugGroups) {
            if (drugGroup?.hasIdentifierForSystem(DrugGroup.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
