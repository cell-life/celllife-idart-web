package org.celllife.idart.domain.dosageinstruction

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.common.*
import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 22h29
 */
class DosageInstruction implements Persistable {

    @JsonIgnore Long pk

    /**
     * Free text dosage instruction
     */
    Set<LocalisedText> texts

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
