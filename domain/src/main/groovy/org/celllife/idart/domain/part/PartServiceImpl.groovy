package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.part.PartEvent.EventType.SAVED
import static org.celllife.idart.domain.part.PartEvent.newPartEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PartServiceImpl implements PartService {

    @Inject PartRepository partRepository

    @Inject PartValidator partValidator

    @Inject PartEventPublisher partEventPublisher
    
    @Inject PartSequence partSequence
    
    @Override
    Boolean exists(PartId partId) {
        partRepository.exists(partId)
    }
    
    @Override
    Part save(Part part) {

        def existingPart = null

        if (part.id != null) {
            existingPart = partRepository.findOne(part.id)
        } else {
            part.id = partSequence.nextValue()
        }

        if (existingPart == null) {
            existingPart = part
        } else {
            existingPart.merge(part)
        }

        partValidator.validate(existingPart)

        partEventPublisher.publish(newPartEvent(existingPart, SAVED))

        partRepository.save(existingPart)
    }
    
    @Override
    Part findByPartId(PartId partId) {

        def part = partRepository.findOne(partId)

        if (part == null) {
            throw new PartNotFoundException("Could not find Part with id [${ partId}]")
        }

        part
    }
}
