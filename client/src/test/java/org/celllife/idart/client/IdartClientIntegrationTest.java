package org.celllife.idart.client;

import org.celllife.idart.client.clinic.Clinic;
import org.celllife.idart.client.form.Form;
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
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasures;
import org.celllife.idart.common.PartClassificationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 19h36
 */
public class IdartClientIntegrationTest {

    private IdartClient idartClient;

    @Before
    public void setUp() throws Exception {
        idartClient = IdartClientSingleton.getInstance("http://localhost:9000/idart", "user@test.cell-life.org", "P@ssw0rd1", "00000001");
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
    public void testGetCompounds() throws Exception {

        List<Compound> compounds = idartClient.getCompounds();
        Assert.assertNotNull(compounds);
        Assert.assertTrue(compounds.size() > 0);

        for (Compound compound : compounds) {
            Assert.assertNotNull(compound);
            Assert.assertNotNull(compound.identifiers);
            Assert.assertTrue(compound.identifiers.size() != 0);
        }
    }

    @Test
    public void testGetDrugs() throws Exception {

        List<Drug> drugs = idartClient.getDrugs();
        Assert.assertNotNull(drugs);
        Assert.assertTrue(drugs.size() > 0);

        for (Drug drug : drugs) {
            Assert.assertNotNull(drug);
            Assert.assertNotNull(drug.identifiers);
            Assert.assertTrue(drug.identifiers.size() != 0);
            Assert.assertNotNull(drug.form);
        }
    }

    @Test
    public void testGetForms() throws Exception {

        List<Form> forms = idartClient.getForms();
        Assert.assertNotNull(forms);
        Assert.assertTrue(forms.size() > 0);

        for (Form form : forms) {
            Assert.assertNotNull(form);
            Assert.assertNotNull(form.code);
            Assert.assertNotNull(form.name);
            Assert.assertNotNull(form.description);
        }
    }

    @Test
    public void testGetUnitsOfMeasure() throws Exception {

        List<UnitOfMeasure> unitsOfMeasure = idartClient.getUnitsOfMeasure();
        Assert.assertNotNull(unitsOfMeasure);
        Assert.assertTrue(unitsOfMeasure.size() > 0);

        for (UnitOfMeasure unitOfMeasure : unitsOfMeasure) {
            Assert.assertNotNull(unitOfMeasure);
            Assert.assertNotNull(unitOfMeasure.code);
            Assert.assertNotNull(unitOfMeasure.name);
            Assert.assertNotNull(unitOfMeasure.description);
        }
    }

    @Test
    public void testCreateClinic() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addIdentifier("http://www.cell-life.org/idart/clinics", "00000001");
    }

    @Test
    public void testCreatePrescription() throws Exception {

        String clinicId = "00000001";

        Prescription prescription = new PrescriptionBuilder(clinicId)
                .setPatient("http://www.pgwc.gov.za", "72254311")
                .setPrescriber("http://prehmis.capetown.gov.za", "1299")
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

        idartClient.savePrescription("00000001", prescription);

        System.out.println(((IdartClientSingleton) idartClient).mapToJson(prescription));
    }

    @Test
    public void testCreateMedication() throws Exception {

        String clinicId = "00000001";

        MedicationBuilder medicationBuilder = new MedicationBuilder(clinicId)
                .setName("[ABC] Abacavir 300mg")
                .addDrug(newDrug(clinicId)
                        .setForm("CAP")
                        .addClassification(PartClassificationType.ATC, "J05AF06")
                        .addBillOfMaterialsItem(newBillOfMaterialsItem()
                                .setQuantity(60, UnitOfMeasures.EACH)
                                .addPart(newDrug(clinicId)
                                        .setId("00000002")
                                        .setForm("CAP")
                                        .addClassification(PartClassificationType.ATC, "J05AF06")
                                        .addBillOfMaterialsItem(newBillOfMaterialsItem()
                                                .setQuantity(300, "mg")
                                                .addPart(newCompound(clinicId)
                                                        .setIdentifier(Compound.INN_SYSTEM, "Abacavir")
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

        idartClient.saveMedication("00000001", medicationBuilder.finishMedication());
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
