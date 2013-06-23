package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.administrationmethod.AdministrationMethod;
import org.celllife.idart.domain.entrysite.EntrySite;
import org.celllife.idart.domain.common.Ratio;
import org.celllife.idart.domain.common.Schedule;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration;
import org.celllife.idart.udm.common.Quantity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 16h58
 */
privileged aspect DosageInstruction_JavaBean {

    public String DosageInstruction.getText() {
        return text;
    }

    public void DosageInstruction.setText(String dosageInstructionsText) {
        this.text = dosageInstructionsText;
    }

    public org.celllife.idart.domain.dosageinstruction.DosageInstruction DosageInstruction.getDosageInstruction() {
        return dosageInstruction;
    }

    public void DosageInstruction.setDosageInstruction(org.celllife.idart.domain.dosageinstruction.DosageInstruction dosageInstruction) {
        this.dosageInstruction = dosageInstruction;
    }

    public Schedule DosageInstruction.getTiming() {
        return timing;
    }

    public void DosageInstruction.setTiming(Schedule timing) {
        this.timing = timing;
    }

    public EntrySite DosageInstruction.getSite() {
        return site;
    }

    public void DosageInstruction.setSite(EntrySite site) {
        this.site = site;
    }

    public RouteOfAdministration DosageInstruction.getRoute() {
        return route;
    }

    public void DosageInstruction.setRoute(RouteOfAdministration route) {
        this.route = route;
    }

    public AdministrationMethod DosageInstruction.getMethod() {
        return method;
    }

    public void DosageInstruction.setMethod(AdministrationMethod method) {
        this.method = method;
    }

    public Quantity DosageInstruction.getDoseQuantity() {
        return doseQuantity;
    }

    public void DosageInstruction.setDoseQuantity(Quantity doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public Ratio DosageInstruction.getRate() {
        return rate;
    }

    public void DosageInstruction.setRate(Ratio rate) {
        this.rate = rate;
    }

    public Ratio DosageInstruction.getMaxDosePerPeriod() {
        return maxDosePerPeriod;
    }

    public void DosageInstruction.setMaxDosePerPeriod(Ratio maxDosePerPeriod) {
        this.maxDosePerPeriod = maxDosePerPeriod;
    }

}
