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

    private String text;

    //public  CodedDosageInstructions additionalDosageInstructions

    private Schedule timing;

    private EntrySite site;

    private RouteOfAdministration route;

    private AdministrationMethod method;

    private Quantity doseQuantity;

    private Ratio rate;

    private Ratio maxDosePerPeriod;

    public DosageInstruction() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Schedule getTiming() {
        return timing;
    }

    public void setTiming(Schedule timing) {
        this.timing = timing;
    }

    public EntrySite getSite() {
        return site;
    }

    public void setSite(EntrySite site) {
        this.site = site;
    }

    public RouteOfAdministration getRoute() {
        return route;
    }

    public void setRoute(RouteOfAdministration route) {
        this.route = route;
    }

    public AdministrationMethod getMethod() {
        return method;
    }

    public void setMethod(AdministrationMethod method) {
        this.method = method;
    }

    public Quantity getDoseQuantity() {
        return doseQuantity;
    }

    public void setDoseQuantity(Quantity doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public Ratio getRate() {
        return rate;
    }

    public void setRate(Ratio rate) {
        this.rate = rate;
    }

    public Ratio getMaxDosePerPeriod() {
        return maxDosePerPeriod;
    }

    public void setMaxDosePerPeriod(Ratio maxDosePerPeriod) {
        this.maxDosePerPeriod = maxDosePerPeriod;
    }
}
