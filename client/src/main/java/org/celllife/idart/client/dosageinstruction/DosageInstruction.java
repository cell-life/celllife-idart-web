package org.celllife.idart.client.dosageinstruction;

import org.celllife.idart.common.*;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class DosageInstruction implements Serializable {

    private String text;

    //public  CodedDosageInstructions additionalDosageInstructions

    private Schedule timing;

    private EntrySiteCode site;

    private RouteOfAdministrationCode route;

    private AdministrationMethodCode method;

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

    public EntrySiteCode getSite() {
        return site;
    }

    public void setSite(EntrySiteCode site) {
        this.site = site;
    }

    public RouteOfAdministrationCode getRoute() {
        return route;
    }

    public void setRoute(RouteOfAdministrationCode route) {
        this.route = route;
    }

    public AdministrationMethodCode getMethod() {
        return method;
    }

    public void setMethod(AdministrationMethodCode method) {
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
