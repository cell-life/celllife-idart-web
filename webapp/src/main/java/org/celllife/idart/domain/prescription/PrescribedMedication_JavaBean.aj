package org.celllife.idart.domain.prescription;

import org.celllife.idart.domain.indication.Indication;
import org.celllife.idart.domain.substitution.Substitution;
import org.celllife.idart.domain.substitutionreason.SubstitutionReason;
import org.celllife.idart.domain.common.Period;
import org.celllife.idart.domain.product.Good;
import org.celllife.idart.framework.aspectj.InjectCoded;
import org.celllife.idart.udm.common.Duration;
import org.celllife.idart.udm.common.Quantity;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 17h01
 */
privileged aspect PrescribedMedication_JavaBean {

    public Good PrescribedMedication.getMedication() {
        return medication;
    }

    @InjectCoded
    public void PrescribedMedication.setMedication(Good medication) {
        this.medication = medication;
    }

    public String PrescribedMedication.getReasonForPrescribing() {
        return reasonForPrescribing;
    }

    public void PrescribedMedication.setReasonForPrescribing(String reasonForPrescribing) {
        this.reasonForPrescribing = reasonForPrescribing;
    }

    public Set<Indication> PrescribedMedication.getIndications() {
        return indications;
    }

    public void PrescribedMedication.setIndications(Set<Indication> reasonForPrescribingIndications) {
        this.indications = reasonForPrescribingIndications;
    }

    public Period PrescribedMedication.getValid() {
        return valid;
    }

    public void PrescribedMedication.setValid(Period valid) {
        this.valid = valid;
    }

    public Integer PrescribedMedication.getNumberOfRepeats() {
        return numberOfRepeats;
    }

    public void PrescribedMedication.setNumberOfRepeats(Integer numberOfRepeats) {
        this.numberOfRepeats = numberOfRepeats;
    }

    public Quantity PrescribedMedication.getQuantity() {
        return quantity;
    }

    public void PrescribedMedication.setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Duration PrescribedMedication.getExpectedSupplyDuration() {
        return expectedSupplyDuration;
    }

    public void PrescribedMedication.setExpectedSupplyDuration(Duration expectedSupplyDuration) {
        this.expectedSupplyDuration = expectedSupplyDuration;
    }

    public Substitution PrescribedMedication.getSubstitution() {
        return substitution;
    }

    public void PrescribedMedication.setSubstitution(Substitution substitution) {
        this.substitution = substitution;
    }

    public SubstitutionReason PrescribedMedication.getSubstitutionReason() {
        return substitutionReason;
    }

    public void PrescribedMedication.setSubstitutionReason(SubstitutionReason substitutionReason) {
        this.substitutionReason = substitutionReason;
    }

    public DosageInstruction PrescribedMedication.getDosageInstruction() {
        return dosageInstruction;
    }

    public void PrescribedMedication.setDosageInstruction(DosageInstruction dosageInstruction) {
        this.dosageInstruction = dosageInstruction;
    }
}
