package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.domain.part.Compound;
import org.celllife.idart.domain.part.CompoundRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@RestResource(path = "compounds")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataCompoundRepository extends PagingAndSortingRepository<Compound, Long>, CompoundRepository{

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
