package org.celllife.idart.domain.defaultdosageinstruction

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.common.PartId
import org.celllife.idart.domain.dosageinstruction.DosageInstruction

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h02
 */
@ToString
@EqualsAndHashCode(excludes = "pk")
class DefaultDosageInstruction implements Serializable {

    Long pk

    PartId drug

    DosageInstruction dosageInstruction

    def merge(DefaultDosageInstruction that) {
        this.drug = that.drug
        this.dosageInstruction = that.dosageInstruction
    }
}
