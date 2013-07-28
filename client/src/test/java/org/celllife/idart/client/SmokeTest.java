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
import org.celllife.idart.client.part.PartClassificationType;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.partyrole.Patient;
import org.celllife.idart.client.partyrole.Practitioner;
import org.celllife.idart.client.prescription.PrescribedMedicationBuilder;
import org.celllife.idart.client.prescription.Prescription;
import org.celllife.idart.client.prescription.PrescriptionBuilder;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasures;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-28
 * Time: 21h27
 */
public class SmokeTest {

    private IdartClient idartClient;

    @Before
    public void setUp() throws Exception {
        idartClient = IdartClientSingleton.getInstance("http://localhost:9000/idart", "user@test.cell-life.org", "P@ssw0rd1", "00000001");
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

        String clinicIdentifier = "00000001";

        MedicationBuilder medicationBuilder = new MedicationBuilder(clinicIdentifier)
                .setName("[ABC] Abacavir 300mg")
                .addDrug(newDrug(clinicIdentifier)
                        .setForm(Form.IDART_SYSTEM, "CAP")
                        .addClassification(PartClassificationType.ATC, "J05AF06")
                        .addBillOfMaterialsItem(newBillOfMaterialsItem()
                                .setQuantity(60, UnitOfMeasures.EACH)
                                .addPart(newDrug(clinicIdentifier)
                                        .setIdentifier("00000002")
                                        .setForm(Form.IDART_SYSTEM, "CAP")
                                        .addClassification(PartClassificationType.ATC, "J05AF06")
                                        .addBillOfMaterialsItem(newBillOfMaterialsItem()
                                                .setQuantity(300, "mg")
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

        // ********************************************************************************************************

        Prescription prescription = new PrescriptionBuilder(clinicIdentifier)
                .addIdentifier("http://www.cell-life.org/idart/prescriptions", System.currentTimeMillis() + "")
                .setPatient("http://www.pgwc.gov.za", "72254311")
                .setPrescriber("http://prehmis.capetown.gov.za", "1299")
                .setDateWritten(new Date())
                .addPrescribedMedication(newPrescribedMedication(clinicIdentifier)
                        .setIdentifier(System.currentTimeMillis() + "")
                        .setMedication("00000001")
                        .setReasonForPrescribing("Because I said so")
                        .setValid(null, new Date())
                        .setExpectedSupplyDuration(4, "wk")
                        .setDosageQuantity(1d, UnitOfMeasures.EACH)
                        .repeat(2)
                        .every(1, UnitOfMeasures.DAY)
                        .finishPrescribedMedication())
                .finishPrescription();

        idartClient.savePrescription(System.currentTimeMillis() + "", prescription);

        System.out.println(((IdartClientSingleton) idartClient).mapToJson(prescription));
    }

    private static PrescribedMedicationBuilder newPrescribedMedication(String clinicIdentifier) {
        return new PrescribedMedicationBuilder(clinicIdentifier);
    }

    private static BillOfMaterialsItemBuilder newBillOfMaterialsItem() {
        return new BillOfMaterialsItemBuilder();
    }

    private static DrugBuilder newDrug(String clinicIdentifier) {
        return new DrugBuilder(clinicIdentifier);
    }

    private static CompoundBuilder newCompound(String clinicIdentifier) {
        return new CompoundBuilder(clinicIdentifier);
    }

}
