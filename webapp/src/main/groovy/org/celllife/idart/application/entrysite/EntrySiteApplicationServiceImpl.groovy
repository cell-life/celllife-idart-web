package org.celllife.idart.application.entrysite

import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.domain.entrysite.EntrySiteNotFoundException
import org.celllife.idart.common.EntrySiteCode
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

    EntrySite findByEntrySiteCode(EntrySiteCode entrySiteCode) throws EntrySiteNotFoundException{
        entrySiteService.findByEntrySiteCode(entrySiteCode)
    }

}
