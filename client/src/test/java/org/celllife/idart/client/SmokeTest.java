package org.celllife.idart.client;

import org.celllife.idart.client.encounter.Encounter;
import org.celllife.idart.client.encounter.EncounterBuilder;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.CompoundBuilder;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.part.DrugBuilder;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.PrescribedMedicationBuilder;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.prescription.PrescriptionBuilder;
import org.celllife.idart.client.product.*;
import org.celllife.idart.common.PartClassificationType;
import org.celllife.idart.common.UnitsOfMeasure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.celllife.idart.common.Identifiers.newIdentifiers;
import static org.celllife.idart.common.Label.label;
import static org.celllife.idart.common.SystemId.systemId;
import static org.celllife.idart.common.Systems.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-28
 * Time: 21h27
 */
public class SmokeTest {

    private IdartClient idartClient;

    private String systemId = "99999999";

    @Before
    public void setUp() throws Exception {
        idartClient = IdartClientSingleton.getInstance("http://localhost:8080/idart", systemId, "E8246BF0-B058-440C-A3D4-783F1A983722");
    }

    @Test
    public void smokeTest() throws Exception {

        // ********************************************************************************************************

        List<Patient> patients = idartClient.getPatients("72254311");
        Assert.assertNotNull(patients);
        Assert.assertTrue(patients.size() > 0);

        for (PartyRole patient : patients) {
            Assert.assertNotNull(patient);
            Assert.assertNotNull(patient.identifiers);
            Assert.assertTrue(patient.identifiers.size() != 0);
            Assert.assertNotNull(patient.person);
            Assert.assertTrue(patient.person.identifiers.size() != 0);
        }

        // ********************************************************************************************************

        List<Practitioner> practitioners = idartClient.getPractitioners();
        Assert.assertNotNull(practitioners);
        Assert.assertTrue(practitioners.size() > 0);

        for (PartyRole practitioner : practitioners) {
            Assert.assertNotNull(practitioner);
            Assert.assertNotNull(practitioner.identifiers);
            Assert.assertTrue(practitioner.identifiers.size() != 0);
            Assert.assertNotNull(practitioner.person);
            Assert.assertTrue(practitioner.person.identifiers.size() != 0);
        }

        // ********************************************************************************************************

        Compound compound = newCompound(systemId)
                .setIdentifier("Abacavir")
                .setLabel(label("Abacavir"))
                .finishCompound();

        idartClient.savePart(compound);

        Drug pill = newDrug(systemId)
                .setIdentifier("00000002")
                .setForm("CAP")
                .setLabel(label("Abacavir 300mg"))
                .addClassification(PartClassificationType.ATC, "J05AF06")
                .addBillOfMaterialsItem(newBillOfMaterialsItem()
                        .setQuantity(300, UnitsOfMeasure.mg.code)
                        .addPart(compound.getIdentifiers())
                        .finishBillOfMaterialsItem()
                )
                .finishDrug();

        idartClient.savePart(pill);

        Drug pills = newDrug(systemId)
                .setIdentifier("00000001")
                .setForm("CAP")
                .setLabel(label("Abacavir 300mg (60 capsules)"))
                .addClassification(PartClassificationType.ATC, "J05AF06")
                .addBillOfMaterialsItem(newBillOfMaterialsItem()
                        .setQuantity(60, UnitsOfMeasure.each.code)
                        .addPart(pill.getIdentifiers())
                        .finishBillOfMaterialsItem()
                )
                .finishDrug();

        idartClient.savePart(pills);

        Medication medication = new MedicationBuilder(systemId)
                .setIdentifier("00000001")
                .setName("[ABC] Abacavir 300mg")
                .addDrug(pills.getIdentifiers())
                .finishMedication();

        idartClient.saveProduct(medication);

        // ********************************************************************************************************

        Encounter encounter = new EncounterBuilder(systemId)
                .setIdentifier("00000001")
                .setStartAt(new Date())
                .setFacility(newIdentifiers(PREHMIS.id, "WES"))
                .finishEncounter();

        idartClient.saveEncounter(encounter);

        // ********************************************************************************************************

        Prescription prescription = new PrescriptionBuilder(systemId)
                .addIdentifier(systemId("99999999"), System.currentTimeMillis() + "")
                .setPatient(PGWC.id, "72254311")
                .setPrescriber(PREHMIS.id, "1299")
                .setEncounter("00000001")
                .setDateWritten(new Date())
                .addPrescribedMedication(newPrescribedMedication(systemId)
                        .setId(System.currentTimeMillis() + "")
                        .setMedication("00000001")
                        .setReasonForPrescribing("Because I said so")
                        .setValid(null, new Date())
                        .setExpectedSupplyDuration(4, UnitsOfMeasure.wk.code)
                        .setDosageQuantity(1d, UnitsOfMeasure.each.code)
                        .repeat(2)
                        .every(1, UnitsOfMeasure.d.code)
                        .finishPrescribedMedication())
                .finishPrescription();

        idartClient.savePrescription(prescription);

        System.out.println(((IdartClientSingleton) idartClient).mapToJson(prescription));
    }

    private static PrescribedMedicationBuilder newPrescribedMedication(String clinicId) {
        return new PrescribedMedicationBuilder(clinicId);
    }

    private static BillOfMaterialsItemBuilder newBillOfMaterialsItem() {
        return new BillOfMaterialsItemBuilder();
    }

    private static DrugBuilder newDrug(String clinicId) {
        return new DrugBuilder(clinicId);
    }

    private static CompoundBuilder newCompound(String clinicId) {
        return new CompoundBuilder(clinicId);
    }

}
