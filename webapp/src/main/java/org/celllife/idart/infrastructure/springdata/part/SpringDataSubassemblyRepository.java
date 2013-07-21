package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.domain.part.Subassembly;
import org.celllife.idart.domain.part.SubassemblyRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h36
 */
@RestResource(path = "subassemblys")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataSubassemblyRepository extends PagingAndSortingRepository<Subassembly, Long>, SubassemblyRepository{

    @Query("select subassembly " +
            "from Subassembly subassembly " +
            "join subassembly.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Subassembly findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct subassembly " +
            "from Subassembly subassembly " +
            "join subassembly.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Subassembly> findByIdentifier(@Param("identifierValue") String identifierValue);
}
