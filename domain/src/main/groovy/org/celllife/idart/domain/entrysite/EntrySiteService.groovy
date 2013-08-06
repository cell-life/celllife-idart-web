package org.celllife.idart.domain.entrysite

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface EntrySiteService {

    EntrySite save(EntrySite entrySite) throws EntrySiteValidationException

    EntrySite findByCode(EntrySiteCode code) throws EntrySiteNotFoundException

}