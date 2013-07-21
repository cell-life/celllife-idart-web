package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.domain.part.RawMaterial;
import org.celllife.idart.domain.part.RawMaterialRepository;

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
@RestResource(path = "rawMaterials")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataRawMaterialRepository extends PagingAndSortingRepository<RawMaterial, Long>, RawMaterialRepository{

    @Query("select rawMaterial " +
            "from RawMaterial rawMaterial " +
            "join rawMaterial.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    RawMaterial findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                      @Param("identifierValue") String identifierValue);

    @Query("select distinct rawMaterial " +
            "from RawMaterial rawMaterial " +
            "join rawMaterial.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<RawMaterial> findByIdentifier(@Param("identifierValue") String identifierValue);
}
