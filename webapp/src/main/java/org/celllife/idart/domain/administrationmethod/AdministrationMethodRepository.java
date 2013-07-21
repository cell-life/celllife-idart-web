package org.celllife.idart.domain.administrationmethod;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@RestResource(path = "administrationMethods")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface AdministrationMethodRepository extends PagingAndSortingRepository<AdministrationMethod, Long> {

    @Query("select administrationMethod " +
            "from AdministrationMethod administrationMethod " +
            "join administrationMethod.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    AdministrationMethod findOneByCode(@Param("system") String system, @Param("code") String code);

}