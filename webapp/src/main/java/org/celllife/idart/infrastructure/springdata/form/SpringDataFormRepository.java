package org.celllife.idart.infrastructure.springdata.form;

import org.celllife.idart.domain.form.Form;
import org.celllife.idart.domain.form.FormCode;
import org.celllife.idart.domain.form.FormRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataFormRepository extends PagingAndSortingRepository<Form, FormCode>, FormRepository {

}
