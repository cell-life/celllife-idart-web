package org.celllife.idart.client.dispensation;

import org.celllife.idart.common.SystemId;

import java.util.Date;

import static org.celllife.idart.common.Identifiers.newIdentifier;
import static org.celllife.idart.common.Identifiers.newIdentifiers;
import static org.celllife.idart.common.SystemId.systemId;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 00h08
 */
public final class DispensationBuilder {

    private Dispensation prescription;

    private SystemId systemId;

    public DispensationBuilder(String systemId) {
        this.prescription = new Dispensation();
        this.systemId = systemId(systemId);
    }

    public DispensationBuilder setIdentifier(String value) {
        this.prescription.setIdentifiers(newIdentifiers(systemId, value));
        return this;
    }

    public DispensationBuilder setPatient(String value) {
        this.prescription.setPatient(newIdentifiers(systemId, value));
        return this;
    }

    public DispensationBuilder setPatient(SystemId systemId, String value) {
        this.prescription.setPatient(newIdentifiers(systemId, value));
        return this;
    }

    public DispensationBuilder setDispenser(String value) {
        this.prescription.setDispenser(newIdentifiers(systemId, value));
        return this;
    }

    public DispensationBuilder setDispenser(SystemId systemId, String value) {
        this.prescription.setDispenser(newIdentifiers(systemId, value));
        return this;
    }

    public DispensationBuilder setEncounter(String value) {
        this.prescription.setFacility(newIdentifiers(systemId, value));
        return this;
    }

    public DispensationBuilder setHandedOver(Date handedOver) {
        this.prescription.setHandedOver(handedOver);
        return this;
    }

    public DispensationBuilder addDispensedMedication(DispensedMedication dispensedMedication) {
        this.prescription.getDispensedMedications().add(dispensedMedication);
        return this;
    }

    public Dispensation finishPrescription() {
        return this.prescription;
    }
}
