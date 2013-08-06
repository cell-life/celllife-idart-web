package org.celllife.idart.infrastructure.springdata.dispensation;

import org.celllife.idart.domain.dispensation.Dispensation;
import org.celllife.idart.domain.dispensation.DispensationRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataDispensationRepository extends PagingAndSortingRepository<Dispensation, Long>, DispensationRepository {

    @Query("select dispensation " +
            "from Dispensation dispensation " +
            "join dispensation.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    Dispensation findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct dispensation " +
            "from Dispensation dispensation " +
            "join dispensation.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<Dispensation> findByIdentifier(@Param("identifierValue") String identifierValue);

}
