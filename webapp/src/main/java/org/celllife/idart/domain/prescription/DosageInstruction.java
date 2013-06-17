package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.common.Rate;
import org.celllife.idart.domain.common.Ratio;
import org.celllife.idart.domain.common.Schedule;
import org.celllife.idart.udm.codedconcept.AdministrationMethod;
import org.celllife.idart.udm.codedconcept.DosageInstructions;
import org.celllife.idart.udm.codedconcept.EntrySite;
import org.celllife.idart.udm.codedconcept.RouteOfAdministration;
import org.celllife.idart.udm.common.Quantity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 22h29
 */
@Embeddable
public final class DosageInstruction implements Serializable {

    private String dosageInstructionsText;

    @ManyToOne
    private DosageInstructions dosageInstructions;

    private Schedule timing;

    @ManyToOne
    private EntrySite site;

    @ManyToOne
    private RouteOfAdministration route;

    @ManyToOne
    private AdministrationMethod method;

    private Quantity doseQuantity;

    private Rate rate;

    private Ratio maxDosePerPeriod;

    public DosageInstruction() {
    }

    public String getDosageInstructionsText() {
        return dosageInstructionsText;
    }

    public void setDosageInstructionsText(String dosageInstructionsText) {
        this.dosageInstructionsText = dosageInstructionsText;
    }

    public DosageInstructions getDosageInstructions() {
        return dosageInstructions;
    }

    public void setDosageInstructions(DosageInstructions dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
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

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Ratio getMaxDosePerPeriod() {
        return maxDosePerPeriod;
    }

    public void setMaxDosePerPeriod(Ratio maxDosePerPeriod) {
        this.maxDosePerPeriod = maxDosePerPeriod;
    }
}
