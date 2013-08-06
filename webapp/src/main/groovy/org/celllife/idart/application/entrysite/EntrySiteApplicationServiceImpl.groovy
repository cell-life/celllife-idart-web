package org.celllife.idart.application.entrysite

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.domain.entrysite.EntrySiteNotFoundException
import org.celllife.idart.domain.entrysite.EntrySiteCode
import org.celllife.idart.domain.entrysite.EntrySiteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class EntrySiteApplicationServiceImpl implements EntrySiteApplicationService {

    @Autowired EntrySiteService entrySiteService

    EntrySite save(EntrySite entrySite) throws EntrySiteValidationException {
        entrySiteService.save(entrySite)
    }

    EntrySite findByCode(EntrySiteCode code) throws EntrySiteNotFoundException{
        entrySiteService.findByCode(code)
    }

}