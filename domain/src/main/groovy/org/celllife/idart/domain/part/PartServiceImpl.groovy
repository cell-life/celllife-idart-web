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

    @Override
    Part save(Part part) {

        partValidator.validate(part)

        partEventPublisher.publish(newPartEvent(part, SAVED))

        partRepository.save(part)
    }

    @Override
    Part findByPartId(PartId partId) {

        def part = partRepository.findOne(partId)

        if (part == null) {
            throw new PartNotFoundException("Could not find Part with Part Id [${ partId}]")
        }

        part
    }
}
