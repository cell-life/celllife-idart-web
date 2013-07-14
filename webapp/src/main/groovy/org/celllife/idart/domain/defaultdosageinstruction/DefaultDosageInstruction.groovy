package org.celllife.idart.domain.defaultdosageinstruction

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.domain.part.FinishedGood

import javax.validation.constraints.NotNull

import static org.celllife.idart.framework.aspectj.InjectIdentified.inject

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h02
 */
@ToString
@EqualsAndHashCode
class DefaultDosageInstruction implements Persistable {

    Long pk

    @NotNull
    FinishedGood medication

    @NotNull
    DosageInstruction dosageInstruction

    void setMedication(FinishedGood medication) {
        this.medication = inject(medication)
    }
}
