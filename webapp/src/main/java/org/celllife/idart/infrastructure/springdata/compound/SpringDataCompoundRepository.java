package org.celllife.idart.infrastructure.springdata.compound;

import org.celllife.idart.domain.compound.Compound;
import org.celllife.idart.domain.compound.CompoundRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataCompoundRepository extends PagingAndSortingRepository<Compound, Long>, CompoundRepository {

    @Query("select compound " +
            "from Compound compound " +
            "join compound.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Compound findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct compound " +
            "from Compound compound " +
            "join compound.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Compound> findByIdentifier(@Param("identifierValue") String identifierValue);

}
