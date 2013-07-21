package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.springframework.beans.factory.annotation.Autowired

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 22h00
 */
@Service class DefaultDosageInstructionServiceImpl implements DefaultDosageInstructionService {

    @Autowired DefaultDosageInstructionRepository defaultDosageInstructionRepository

    @Override
    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) {

        def existingDefaultDosageInstruction = findByIdentifiers(defaultDosageInstruction.identifiers)

        if (existingDefaultDosageInstruction == null) {
            existingDefaultDosageInstruction = new DefaultDosageInstruction()
        }

        existingDefaultDosageInstruction.merge(defaultDosageInstruction)

        defaultDosageInstructionRepository.save(existingDefaultDosageInstruction)
    }

    @Override
    Iterable<DefaultDosageInstruction> findAll() {
        defaultDosageInstructionRepository.findAll()
    }

    @Override
    DefaultDosageInstruction findByIdentifier(String medicationIdentifier) {
        defaultDosageInstructionRepository
                .findOneByIdentifier("http://www.celllife.org/idart/medications", medicationIdentifier)
    }

    @Override
    DefaultDosageInstruction findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def defaultDosageInstruction = defaultDosageInstructionRepository.findOneByIdentifier(identifier.system, identifier.value)

            if (defaultDosageInstruction != null) {
                return defaultDosageInstruction
            }
        }

        null
    }
    
}
