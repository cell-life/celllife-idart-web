package org.celllife.idart.application.dispensation;

import org.celllife.idart.domain.dispensation.Dispensation;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensationResourceService {

    Dispensation save(Dispensation dispensation);

    Dispensation findByIdentifier(String identifier);

    Iterable<Dispensation> findAll();

}