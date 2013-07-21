package org.celllife.idart.client;

import org.celllife.idart.client.common.LocalizedText;
import org.celllife.idart.client.form.Form;
import org.celllife.idart.client.part.Compound;
import org.celllife.idart.client.part.Drug;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.unitofmeasure.UnitOfMeasure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * User: Kevin W. Sewell
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
        List<PartyRole> patients = idartClient.getPatients("999999", "72254311");
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
        List<PartyRole> practitioners = idartClient.getPractitioners("999999");
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

        List<Drug> drugs = idartClient.getDrugs("999999");
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
                for (LocalizedText description : form.descriptions) {
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
                for (LocalizedText description : unitOfMeasure.descriptions) {
                    Assert.assertNotNull(description);
                    Assert.assertNotNull(description.locale);
                    Assert.assertNotNull(description.value);
                }
            }
        }
    }
}
