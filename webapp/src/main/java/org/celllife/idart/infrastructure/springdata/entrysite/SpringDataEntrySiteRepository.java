package org.celllife.idart.infrastructure.springdata.entrysite;

import org.celllife.idart.domain.entrysite.EntrySite;
import org.celllife.idart.domain.entrysite.EntrySiteCode;
import org.celllife.idart.domain.entrysite.EntrySiteRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataEntrySiteRepository extends PagingAndSortingRepository<EntrySite, EntrySiteCode>, EntrySiteRepository {

}
