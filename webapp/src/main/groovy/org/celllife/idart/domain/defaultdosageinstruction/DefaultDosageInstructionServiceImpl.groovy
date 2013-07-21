package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 22h00
 */
@Service class DefaultDosageInstructionServiceImpl implements DefaultDosageInstructionService {

    @Autowired DefaultDosageInstructionRepository defaultDosageInstructionRepository

    @Override
    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) {

        def existingDefaultDosageInstruction = findByIdentifiers(defaultDosageInstruction.medication.identifiers)

        if (existingDefaultDosageInstruction == null) {
            existingDefaultDosageInstruction = new DefaultDosageInstruction()
        }
        existingDefaultDosageInstruction.medication = defaultDosageInstruction.medication

        if (existingDefaultDosageInstruction.dosageInstruction != null) {
            defaultDosageInstruction.dosageInstruction.pk = existingDefaultDosageInstruction.dosageInstruction.pk
        }
        existingDefaultDosageInstruction.dosageInstruction = defaultDosageInstruction.dosageInstruction

        defaultDosageInstructionRepository.save(existingDefaultDosageInstruction)
    }

    @Override
    Iterable<DefaultDosageInstruction> findAll() {
        defaultDosageInstructionRepository.findAll()
    }

    @Override
    DefaultDosageInstruction findByIdentifier(String medicationIdentifier) {
        defaultDosageInstructionRepository
                .findOneByMedicationIdentifier("http://www.celllife.org/idart/medications", medicationIdentifier)
    }

    @Override
    DefaultDosageInstruction findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def defaultDosageInstruction = defaultDosageInstructionRepository
                    .findOneByMedicationIdentifier(identifier.system, identifier.value)

            if (defaultDosageInstruction != null) {
                return defaultDosageInstruction
            }
        }

        null
    }
    
}
