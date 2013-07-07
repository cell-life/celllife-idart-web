package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
abstract class Part implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    @NotNull
    String name

    UnitOfMeasure unitOfMeasure

    Form form

}
