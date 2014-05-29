package org.celllife.idart.client;

import static org.celllife.idart.common.Label.label;
import static org.celllife.idart.common.Systems.PGWC;
import static org.celllife.idart.common.Systems.PREHMIS;

import java.util.Date;
import java.util.List;

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
import org.celllife.idart.client.product.BillOfMaterialsItemBuilder;
import org.celllife.idart.client.product.Medication;
import org.celllife.idart.client.product.MedicationBuilder;
import org.celllife.idart.common.PartClassificationType;
import org.celllife.idart.common.UnitsOfMeasure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h36
 */
//@Ignore
public class IdartClientIntegrationTest {

    private IdartClient idartClient;

    private String systemId = "99999999";

    @Before
    public void setUp() throws Exception {
        idartClient = IdartClientSingleton.getInstance("http://localhost:8080/idart", systemId, "E8246BF0-B058-440C-A3D4-783F1A983722");
    }

    @Test
    public void testGetPatients() throws Exception {
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
    }

    @Test
    public void testGetPractitioners() throws Exception {
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
    }

    @Test
    public void testCreatePrescription() throws Exception {

        Prescription prescription = new PrescriptionBuilder(systemId)
                .setIdentifier("00000001")
                .setPatient(PGWC.id, "72254311")
                .setPrescriber(PREHMIS.id, "1299")
                .setDateWritten(new Date())
                .addPrescribedMedication(newPrescribedMedication(systemId)
                        .setId("00000001")
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

    @Test
    public void testCreateMedication() throws Exception {

        Compound compound = newCompound(systemId)
                .setIdentifier("Abacavir")
                .setLabel(label("Abacavir"))
                .finishCompound();

        idartClient.savePart(compound);

        Drug pills = newDrug(systemId)
                .setIdentifier("00000002")
                .setForm("CAP")
                .setLabel(label("Abacavir 300mg (60 capsules)"))
                .addClassification(PartClassificationType.ATC, "J05AF06")
                .setQuantity(20, UnitsOfMeasure.each.code)
                .addBillOfMaterialsItem(newBillOfMaterialsItem()
                        .setQuantity(300, UnitsOfMeasure.mg.code)
                        .addPart(compound.getIdentifiers())
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
    }

    private static PrescribedMedicationBuilder newPrescribedMedication(String systemId) {
        return new PrescribedMedicationBuilder(systemId);
    }

    private static BillOfMaterialsItemBuilder newBillOfMaterialsItem() {
        return new BillOfMaterialsItemBuilder();
    }

    private static DrugBuilder newDrug(String systemId) {
        return new DrugBuilder(systemId);
    }

    private static CompoundBuilder newCompound(String systemId) {
        return new CompoundBuilder(systemId);
    }
}
