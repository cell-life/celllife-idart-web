package org.celllife.idart.domain.form;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 17h50
 */
@RestResource(path = "forms")
public interface FormRespository extends PagingAndSortingRepository<Form, Long> {

    @Query("select form " +
            "from Form form " +
            "join form.codes.codes code " +
            "where code.system = :system " +
            "and code.value = :code ")
    Form findOneBySystemAndCode(@Param("system") String system, @Param("code") String code);
}
