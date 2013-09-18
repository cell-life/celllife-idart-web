package org.celllife.idart.client;

import org.celllife.idart.client.medication.BillOfMaterialsItemBuilder;
import org.celllife.idart.client.medication.CompoundBuilder;
import org.celllife.idart.client.medication.DrugBuilder;
import org.celllife.idart.client.medication.MedicationBuilder;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.PrescribedMedicationBuilder;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.prescription.PrescriptionBuilder;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasures;
import org.celllife.idart.common.PartClassificationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.celllife.idart.common.SystemId.*;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h36
 */
public class IdartClientIntegrationTest {

    private IdartClient idartClient;

    @Before
    public void setUp() throws Exception {
        idartClient = IdartClientSingleton.getInstance("http://localhost:8080/idart", "99999999", "E8246BF0-B058-440C-A3D4-783F1A983722");
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

        String clinicId = "00000001";

        Prescription prescription = new PrescriptionBuilder(clinicId)
                .setIdentifier("00000001")
                .setPatient(PGWC, "72254311")
                .setPrescriber(PREHMIS, "1299")
                .setDateWritten(new Date())
                .addPrescribedMedication(newPrescribedMedication(clinicId)
                        .setId("00000001")
                        .setMedication("00000001")
                        .setReasonForPrescribing("Because I said so")
                        .setValid(null, new Date())
                        .setExpectedSupplyDuration(4, "wk")
                        .setDosageQuantity(1d, UnitOfMeasures.EACH)
                        .repeat(2)
                        .every(1, UnitOfMeasures.DAY)
                        .finishPrescribedMedication())
                .finishPrescription();

        idartClient.savePrescription(prescription);

        System.out.println(((IdartClientSingleton) idartClient).mapToJson(prescription));
    }

    @Test
    public void testCreateMedication() throws Exception {

        String systemId = "00000001";

        MedicationBuilder medicationBuilder = new MedicationBuilder(systemId)
                .setIdentifier("00000001")
                .setName("[ABC] Abacavir 300mg")
                .addDrug(newDrug(systemId)
                        .setForm("CAP")
                        .addClassification(PartClassificationType.ATC, "J05AF06")
                        .addBillOfMaterialsItem(newBillOfMaterialsItem()
                                .setQuantity(60, UnitOfMeasures.EACH)
                                .addPart(newDrug(systemId)
                                        .setIdentifier("00000002")
                                        .setForm("CAP")
                                        .addClassification(PartClassificationType.ATC, "J05AF06")
                                        .addBillOfMaterialsItem(newBillOfMaterialsItem()
                                                .setQuantity(300, "mg")
                                                .addPart(newCompound(systemId)
                                                        .setIdentifier(systemId("IDART_WEB"), "Abacavir")
                                                        .finishCompound()
                                                )
                                                .finishBillOfMaterialsItem()
                                        )
                                        .finishDrug()
                                )
                                .finishBillOfMaterialsItem()
                        )
                        .finishDrug()
                );

        idartClient.saveMedication(medicationBuilder.finishMedication());
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
