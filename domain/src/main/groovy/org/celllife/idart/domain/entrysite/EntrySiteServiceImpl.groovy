package org.celllife.idart.domain.entrysite

import org.celllife.idart.common.EntrySiteCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class EntrySiteServiceImpl implements EntrySiteService {

    @Autowired EntrySiteRepository entrySiteRepository

    @Autowired EntrySiteValidator entrySiteValidator

    @Autowired EntrySiteEventPublisher entrySiteEventPublisher

    @Override
    EntrySite save(EntrySite entrySite) throws EntrySiteValidationException {

        entrySiteValidator.validate(entrySite)

        entrySiteEventPublisher.entrySiteSaved(entrySite)

        entrySiteRepository.save(entrySite)
    }

    @Override
    EntrySite findByEntrySiteCode(EntrySiteCode entrySiteCode) throws EntrySiteNotFoundException {

        def entrySite = entrySiteRepository.findOne(entrySiteCode)

        if (entrySite == null) {
            throw new EntrySiteNotFoundException("Could not find EntrySite with Entry Site Code [${ entrySiteCode}]")
        }

        entrySite
    }
}