package org.celllife.idart.integration.prehmis

import org.celllife.idart.application.prescription.PrescriptionProvider
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.common.Duration
import org.celllife.idart.common.Period
import org.celllife.idart.common.Quantity
import org.celllife.idart.common.Repeat
import org.celllife.idart.common.Schedule
import org.celllife.idart.domain.dosageinstruction.DosageInstruction
import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.medication.Medication
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.celllife.idart.common.PartClassificationType.ATC

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 16h00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
class PrehmisClinicPrescriptionProviderIntegrationTest {

    @Autowired PrescriptionProvider prehmisClinicPrescriptionProvider

    @Test
    void testFindById() throws Exception {

        def clinic = new Clinic()
        ((Facility) clinic).addId("http://prehmis.capetown.gov.za", "WES")

        def patient = new Patient()
        patient.with {
            addId("http://www.pgwc.gov.za", "72254311")
            addId("http://prehmis.capetown.gov.za", "1")
            person = new Person()
//            person.with {
//                addId(PrehmisPatientIdType.SAID.system, "")
//            }
        }
        def practitioner = new Practitioner()
        practitioner.with {
            addId("http://prehmis.capetown.gov.za", "1500")
        }

        def prescribedMedication1 = new PrescribedMedication()
        prescribedMedication1.with {
            medication = new Medication()
            medication.with {
                drug = new Drug()
                drug.addClassification(ATC, "J05AF04")
            }
            expectedSupplyDuration = new Duration(unitOfMeasure: new UnitOfMeasure(), value: 4)
            valid = new Period(fromDate: new Date(), thruDate: oneMonthFromToday)
            reasonForPrescribing = "Because I want to"
            dosageInstruction = new DosageInstruction()
            dosageInstruction.with {
                doseQuantity = new Quantity(unitOfMeasure: new UnitOfMeasure(), value: 1)
                timing = new Schedule()
                timing.with {
                    repeat = new Repeat()
                    repeat.with {
                        frequency = 2
                    }
                }
            }
        }

        def prescription = new Prescription()
        prescription.addId(Prescription.IDART_SYSTEM, (System.currentTimeMillis() + "").substring(0,8))
        prescription.patient = patient
        prescription.prescriber = practitioner
        prescription.dateWritten = new Date()
        prescription.prescribedMedications.add(prescribedMedication1)

        prehmisClinicPrescriptionProvider.save(clinic, prescription)
    }

    static Date getOneMonthFromToday() {
        def calendar = new GregorianCalendar()
        calendar.add(Calendar.MONTH, 1)
        calendar.time
    }
}
