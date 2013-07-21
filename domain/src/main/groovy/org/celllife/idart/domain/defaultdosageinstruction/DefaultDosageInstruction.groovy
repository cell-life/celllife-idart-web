package org.celllife.idart.domain.defaultdosageinstruction

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.domain.part.FinishedGood

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h02
 */
@ToString
@EqualsAndHashCode(excludes = "pk")
class DefaultDosageInstruction implements Persistable<Long> {

    Long pk

    @NotNull
    FinishedGood medication

    @NotNull
    DosageInstruction dosageInstruction

}
