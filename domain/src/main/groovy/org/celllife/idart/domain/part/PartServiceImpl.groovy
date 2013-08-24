package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.part.PartEvent.EventType.SAVED
import static org.celllife.idart.domain.part.PartEvent.newPartEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PartServiceImpl implements PartService {

    @Autowired PartRepository partRepository

    @Autowired PartValidator partValidator

    @Autowired PartEventPublisher partEventPublisher

    @Override
    Part save(Part part) throws PartValidationException {

        partValidator.validate(part)

        partEventPublisher.publish(newPartEvent(part, SAVED))

        partRepository.save(part)
    }

    @Override
    Part findByPartId(PartId partId) throws PartNotFoundException {

        def part = partRepository.findOne(partId)

        if (part == null) {
            throw new PartNotFoundException("Could not find Part with Part Id [${ partId}]")
        }

        part
    }
}
