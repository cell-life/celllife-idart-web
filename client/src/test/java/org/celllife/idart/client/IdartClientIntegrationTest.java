package org.celllife.idart.client;

import org.celllife.idart.client.clinic.Clinic;
import org.celllife.idart.client.common.LocalisedText;
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
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.prescription.PrescriptionBuilder;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;
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

    static {
        IdartClientSingleton.idartWebUsername = "user@test.cell-life.org";
        IdartClientSingleton.idartWebPassword = "P@ssw0rd1";
        IdartClientSingleton.idartWebUrl = "http://localhost:9000/idart";
        IdartClientSingleton.idartApplicationId = "2AEFB796-8501-45C3-A0CE-3818088D338D";
    }

    private IdartClient idartClient;

    @Before
    public void setUp() throws Exception {
        idartClient = IdartClientSingleton.getInstance();
    }

    @Test
    public void testGetPatients() throws Exception {
        List<Patient> patients = idartClient.getPatients("00000001", "72254311");
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
        List<Practitioner> practitioners = idartClient.getPractitioners("00000001");
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

        List<Drug> drugs = idartClient.getDrugs("00000001");
        Assert.assertNotNull(drugs);
        Assert.assertTrue(drugs.size() > 0);

        for (Drug drug : drugs) {
            Assert.assertNotNull(drug);
            Assert.assertNotNull(drug.identifiers);
            Assert.assertTrue(drug.identifiers.size() != 0);
            if (drug.form != null) {
                Assert.assertNotNull(drug.form.codes);
            }
        }
    }

    @Test
    public void testGetForms() throws Exception {

        List<Form> forms = idartClient.getForms();
        Assert.assertNotNull(forms);
        Assert.assertTrue(forms.size() > 0);

        for (Form form : forms) {
            Assert.assertNotNull(form);
            Assert.assertNotNull(form.codes);
            Assert.assertTrue(form.codes.size() != 0);
            Assert.assertNotNull(form.names);
            Assert.assertTrue(form.names.size() != 0);
            if (form.descriptions != null) {
                for (LocalisedText description : form.descriptions) {
                    Assert.assertNotNull(description);
                    Assert.assertNotNull(description.locale);
                    Assert.assertNotNull(description.value);
                }
            }
        }
    }

    @Test
    public void testGetUnitsOfMeasure() throws Exception {

        List<UnitOfMeasure> unitsOfMeasure = idartClient.getUnitsOfMeasure();
        Assert.assertNotNull(unitsOfMeasure);
        Assert.assertTrue(unitsOfMeasure.size() > 0);

        for (UnitOfMeasure unitOfMeasure : unitsOfMeasure) {
            Assert.assertNotNull(unitOfMeasure);
            Assert.assertNotNull(unitOfMeasure.codes);
            Assert.assertTrue(unitOfMeasure.codes.size() != 0);
            Assert.assertNotNull(unitOfMeasure.names);
            Assert.assertTrue(unitOfMeasure.names.size() != 0);
            if (unitOfMeasure.descriptions != null) {
                for (LocalisedText description : unitOfMeasure.descriptions) {
                    Assert.assertNotNull(description);
                    Assert.assertNotNull(description.locale);
                    Assert.assertNotNull(description.value);
                }
            }
        }
    }

    @Test
    public void testCreateClinic() throws Exception {
        Clinic clinic = new Clinic();
        clinic.addIdentifier("http://www.cell-life.org/idart/clinics", "00000001");
    }

    @Test
    public void testCreatePrescription() throws Exception {

        Prescription prescription = new PrescriptionBuilder("00000001")
                .setIdentifier("00000001")
                .setPatient("http://www.pgwc.gov.za", "72254311")
                .setPrescriber("http://prehmis.capetown.gov.za", "1299")
                .setDateWritten(new Date())
                .addPrescribedMedication()
                .setMedication("00000001")
                .setDosageQuantity(1, "http://www.cell-life.org/idart/unitsOfMeasure", "each")
                .repeat(2)
                .every(1, "http://unitsofmeasure.org", "d")
                .finishPrescribedMedication()
                .finishPrescription();

        idartClient.savePrescription("00000001", prescription);

        System.out.println(((IdartClientSingleton) idartClient).mapToJson(prescription));
    }

    /*
     *
                .addPrescribedMedication()
                .setMedication("00000002")
                .setDosageQuantity(100, "http://unitsofmeasure.org", "ml")
                .repeat(1)
                .every(4, "http://unitsofmeasure.org", "h")
                .finishPrescribedMedication()
     *
     */

    @Test
    public void testCreateMedication() throws Exception {

        String clinicIdentifier = "00000001";

        MedicationBuilder medicationBuilder = new MedicationBuilder(clinicIdentifier)
                .setIdentifier("00000001")
                .setName("[ABC] Abacavir 300mg");

        medicationBuilder.addDrug(newDrug(clinicIdentifier)
                .setIdentifier("00000001")
                .setForm(Form.IDART_SYSTEM, "CAP")
                .addBillOfMaterialsItem(newBillOfMaterialsItem()
                        .setQuantity(60, UnitOfMeasure.IDART_SYSTEM, "each")
                        .addPart(newDrug(clinicIdentifier)
                                .setIdentifier("00000002")
                                .setForm(Form.IDART_SYSTEM, "CAP")
                                .addBillOfMaterialsItem(newBillOfMaterialsItem()
                                        .setQuantity(300, UnitOfMeasure.UCUM_SYSTEM, "mg")
                                        .addPart(newCompound(clinicIdentifier)
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

    private BillOfMaterialsItemBuilder newBillOfMaterialsItem() {
        return new BillOfMaterialsItemBuilder();
    }

    private DrugBuilder newDrug(String clinicIdentifier) {
        return new DrugBuilder(clinicIdentifier);
    }

    private CompoundBuilder newCompound(String clinicIdentifier) {
        return new CompoundBuilder(clinicIdentifier);
    }
}
