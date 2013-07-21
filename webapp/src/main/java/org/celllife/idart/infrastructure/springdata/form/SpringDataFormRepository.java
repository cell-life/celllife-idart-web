package org.celllife.idart.infrastructure.springdata.form;

import org.celllife.idart.domain.form.Form;
import org.celllife.idart.domain.form.FormRepository;

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
@RestResource(path = "forms")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataFormRepository extends PagingAndSortingRepository<Form, Long>, FormRepository {

    @Query("select form " +
            "from Form form " +
            "join form.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    Form findOneByCode(@Param("system") String system, @Param("code") String code);

}
