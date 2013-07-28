package org.celllife.idart.domain.defaultdosageinstruction

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.domain.drug.Drug

import javax.validation.constraints.NotNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h02
 */
@ToString
@EqualsAndHashCode(excludes = "pk")
class DefaultDosageInstruction {

    Long pk

    @NotNull
    Drug medication

    @NotNull
    DosageInstruction dosageInstruction

    def merge(DefaultDosageInstruction that) {
        this.medication = that.medication
        this.dosageInstruction = that.dosageInstruction
    }

    def getIdentifiers() {
        medication?.identifiers
    }
}
