package org.celllife.idart.domain.dosageinstruction

import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.common.Quantity
import org.celllife.idart.common.Ratio
import org.celllife.idart.common.Schedule

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 22h29
 */
class DosageInstruction {

    Long pk

    /**
     * Free text dosage instruction
     */
    String text

    /**
     * Coded dosage instruction
     */
    // CodedDosageInstructions additionalDosageInstructions

    /**
     * Timing
     */
    Schedule timing

    /**
     * Location on body
     */
    EntrySiteCode site

    /**
     * Route Of Administration
     */
    RouteOfAdministrationCode route

    /**
     * Administration Method
     */
    AdministrationMethodCode method

    /**
     * Dose Quantity
     */
    Quantity doseQuantity

    /**
     * Rate
     */
    Ratio rate

    /**
     * Max Dose Per Period
     */
    Ratio maxDosePerPeriod

}
