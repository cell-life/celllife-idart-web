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

        def existingDefaultDosageInstruction = findOneByIdentifiers(defaultDosageInstruction.medication.identifiers)

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


    DefaultDosageInstruction findOneByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def defaultDosageInstruction = defaultDosageInstructionRepository
                    .findOneByMedicationIdentifier(identifier.getSystem(), identifier.getValue())

            if (defaultDosageInstruction != null) {
                return defaultDosageInstruction
            }
        }

        null
    }
    
}
