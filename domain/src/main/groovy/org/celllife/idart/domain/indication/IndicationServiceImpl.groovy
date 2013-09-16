package org.celllife.idart.domain.indication

import org.celllife.idart.common.IndicationCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.indication.IndicationEvent.EventType.SAVED
import static org.celllife.idart.domain.indication.IndicationEvent.newIndicationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class IndicationServiceImpl implements IndicationService {

    @Inject IndicationRepository indicationRepository

    @Inject IndicationValidator indicationValidator

    @Inject IndicationEventPublisher indicationEventPublisher

    @Override
    Boolean exists(IndicationCode indicationCode) {
        indicationRepository.exists(indicationCode)
    }

    @Override
    Indication save(Indication indication) {

        def existingIndication = indicationRepository.findOne(indication.id)

        if (existingIndication == null) {
            existingIndication = indication
        } else {
            existingIndication.merge(indication)
        }

        indicationValidator.validate(existingIndication)

        indicationEventPublisher.publish(newIndicationEvent(existingIndication, SAVED))

        indicationRepository.save(existingIndication)
    }

    @Override
    Indication findByIndicationCode(IndicationCode indicationCode) {

        def indication = indicationRepository.findOne(indicationCode)

        if (indication == null) {
            throw new IndicationNotFoundException("Could not find Indication with code [${ indicationCode}]")
        }

        indication
    }
}
