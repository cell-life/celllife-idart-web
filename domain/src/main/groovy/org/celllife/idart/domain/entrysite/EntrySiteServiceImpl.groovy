package org.celllife.idart.domain.entrysite

import org.celllife.idart.common.EntrySiteCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.entrysite.EntrySiteEvent.EventType.SAVED
import static org.celllife.idart.domain.entrysite.EntrySiteEvent.newEntrySiteEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EntrySiteServiceImpl implements EntrySiteService {

    @Inject EntrySiteRepository entrySiteRepository

    @Inject EntrySiteValidator entrySiteValidator

    @Inject EntrySiteEventPublisher entrySiteEventPublisher
    
    @Override
    Boolean exists(EntrySiteCode entrySiteCode) {
        entrySiteRepository.exists(entrySiteCode)
    }
    
    @Override
    EntrySite save(EntrySite entrySite) {

        entrySiteValidator.validate(entrySite)

        entrySiteEventPublisher.publish(newEntrySiteEvent(entrySite, SAVED))

        entrySiteRepository.save(entrySite)
    }
    
    @Override
    EntrySite findByEntrySiteCode(EntrySiteCode entrySiteCode) {

        def entrySite = entrySiteRepository.findOne(entrySiteCode)

        if (entrySite == null) {
            throw new EntrySiteNotFoundException("Could not find EntrySite with code [${ entrySiteCode}]")
        }

        entrySite
    }
}
