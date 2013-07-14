package org.celllife.idart.domain.part;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 21h34
 */
@RestResource(path = "rawMaterials")
public interface RawMaterialRepository extends PagingAndSortingRepository<RawMaterial, Long> {

    @Query("select rawMaterial " +
            "from RawMaterial rawMaterial " +
            "join rawMaterial.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    RawMaterial findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                    @Param("identifierValue") String identifierValue);
}

