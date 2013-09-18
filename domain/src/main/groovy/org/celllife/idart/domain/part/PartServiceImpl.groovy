package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId
import org.celllife.idart.common.PartType

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.PartType.COMPOUND
import static org.celllife.idart.common.PartType.DRUG
import static org.celllife.idart.domain.part.PartEvent.EventType.SAVED
import static org.celllife.idart.domain.part.PartEvent.newPartEvent

/**
 */
@Named class PartServiceImpl implements PartService {

    @Inject PartRepository partRepository

    @Inject PartValidator partValidator

    @Inject PartEventPublisher partEventPublisher

    @Override
    Boolean exists(PartId partId) {
        partRepository.exists(partId)
    }

    @Override
    Part save(Part part) {

        def existingPart = partRepository.findOne(part.id)

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

    @Override
    Set<Part> findByType(PartType type) {

        switch (type) {
            case COMPOUND:
                def parts = partRepository.findByClass(Compound)
                return parts as Set
            case DRUG:
                def parts = partRepository.findByClass(Drug)
                return parts as Set
            default:
                return new HashSet<Part>()
        }
    }
}
