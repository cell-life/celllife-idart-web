package org.celllife.idart.domain.dispensation;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensationRepository {

    Dispensation save(Dispensation dispensation)

    public <S extends Dispensation> Iterable<S> save(Iterable<S> dispensations)

    Dispensation findOne(Long pk)

    Iterable<Dispensation> findAll()

    Dispensation findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Dispensation> findByIdentifier(String identifierValue)
}
