package org.celllife.idart.application.part;

import org.celllife.idart.domain.part.FinishedGood;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FinishedGoodResourceService {

    FinishedGood save(FinishedGood finishedGood);

    FinishedGood findByIdentifier(String identifier);

    Iterable<FinishedGood> findAll();

}