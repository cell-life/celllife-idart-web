package org.celllife.idart.infrastructure.springdata.encounter;

import org.celllife.idart.common.EncounterId;
import org.celllife.idart.domain.encounter.Encounter;
import org.celllife.idart.domain.encounter.EncounterRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataEncounterRepository extends EncounterRepository,
        PagingAndSortingRepository<Encounter, EncounterId> {

}
