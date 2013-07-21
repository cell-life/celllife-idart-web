package org.celllife.idart.domain.form;

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
@RestResource(path = "forms")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FormRepository extends PagingAndSortingRepository<Form, Long> {

    @Query("select form " +
            "from Form form " +
            "join form.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    Form findOneByCode(@Param("system") String system, @Param("code") String code);

}
