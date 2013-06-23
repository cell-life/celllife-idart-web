package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.common.Ratio;
import org.celllife.idart.domain.common.Schedule;
import org.celllife.idart.domain.administrationmethod.AdministrationMethod;
import org.celllife.idart.domain.entrysite.EntrySite;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration;
import org.celllife.idart.udm.common.Quantity;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 22h29
 */
public final class DosageInstruction implements Serializable {

    /**
     * Free text dosage instruction
     */
    private String text;

    /**
     * Coded dosage instruction
     */
    private org.celllife.idart.domain.dosageinstruction.DosageInstruction dosageInstruction;

    /**
     * Timing
     */
    private Schedule timing;

    /**
     * Location on body
     */
    private EntrySite site;

    /**
     * Route Of Administration
     */
    private RouteOfAdministration route;

    /**
     * Administration Method
     */
    private AdministrationMethod method;

    /**
     * Dose Quantity
     */
    private Quantity doseQuantity;

    /**
     * Rate
     */
    private Ratio rate;

    /**
     * Max Dose Per Period
     */
    private Ratio maxDosePerPeriod;

    public DosageInstruction() {
    }

}
