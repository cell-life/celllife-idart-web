package org.celllife.idart.infrastructure.springdata.form;

import org.celllife.idart.common.FormCode;
import org.celllife.idart.domain.form.Form;
import org.celllife.idart.domain.form.FormRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataFormRepository extends FormRepository,
        PagingAndSortingRepository<Form, FormCode> {

}