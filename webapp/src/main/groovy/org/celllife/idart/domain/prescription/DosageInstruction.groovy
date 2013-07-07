package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.common.Quantity
import org.celllife.idart.domain.concept.Ratio
import org.celllife.idart.domain.concept.Schedule
import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 22h29
 */
class DosageInstruction {

    /**
     * Free text dosage instruction
     */
    String text

    /**
     * Coded dosage instruction
     */
    org.celllife.idart.domain.dosageinstruction.DosageInstruction dosageInstruction

    /**
     * Timing
     */
    Schedule timing

    /**
     * Location on body
     */
    EntrySite site

    /**
     * Route Of Administration
     */
    RouteOfAdministration route

    /**
     * Administration Method
     */
    AdministrationMethod method

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
