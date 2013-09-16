package org.celllife.idart.client.dosageinstruction;

import org.celllife.idart.client.administrationmethod.AdministrationMethod;
import org.celllife.idart.common.Quantity;
import org.celllife.idart.common.Ratio;
import org.celllife.idart.common.Schedule;
import org.celllife.idart.client.entrysite.EntrySite;
import org.celllife.idart.client.routeofadministration.RouteOfAdministration;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class DosageInstruction implements Serializable {

    public String text;

    //public  CodedDosageInstructions additionalDosageInstructions

    public Schedule timing;

    public EntrySite site;

    public RouteOfAdministration route;

    public AdministrationMethod method;

    public Quantity doseQuantity;

    public Ratio rate;

    public Ratio maxDosePerPeriod;

    public DosageInstruction() {
    }
}
