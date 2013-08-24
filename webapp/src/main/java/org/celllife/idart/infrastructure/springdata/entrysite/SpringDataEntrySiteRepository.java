package org.celllife.idart.infrastructure.springdata.entrysite;

import org.celllife.idart.common.EntrySiteCode;
import org.celllife.idart.domain.entrysite.EntrySite;
import org.celllife.idart.domain.entrysite.EntrySiteRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataEntrySiteRepository extends EntrySiteRepository,
        PagingAndSortingRepository<EntrySite, EntrySiteCode> {

}
