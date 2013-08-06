package org.celllife.idart.domain.entrysite

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class EntrySiteServiceImpl implements EntrySiteService {

    @Autowired EntrySiteRepository entrySiteRepository

    @Autowired EntrySiteValidator entrySiteValidator

    @Override
    EntrySite save(EntrySite entrySite) throws EntrySiteValidationException {

        entrySiteValidator.validate(entrySite)

        entrySiteRepository.save(entrySite)
    }

    @Override
    EntrySite findByCode(EntrySiteCode code) throws EntrySiteNotFoundException {

        def entrySite = entrySiteRepository.findOne(code)

        if (entrySite == null) {
            throw new EntrySiteNotFoundException("Could not find EntrySite with Code [${ code}]")
        }

        entrySite
    }
}