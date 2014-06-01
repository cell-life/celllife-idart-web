package org.celllife.idart.domain.dosageinstruction

import org.celllife.idart.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 22h29
 */
class DosageInstruction implements Serializable {

    private static final long serialVersionUID = 530452930800313124L;

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
