package org.celllife.idart.application.prescription

import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.practitioner.PractitionerService
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionService
import org.celllife.idart.domain.product.GoodService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h46
 */
@Service class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService, PrescriptionResourceService {

    @Autowired PatientService patientService

    @Autowired PractitionerService practitionerService

    @Autowired GoodService goodService

    @Autowired PrescriptionService prescriptionService

    @Autowired UnitOfMeasureService unitOfMeasureService

    Prescription save(Prescription prescription) {

        prescription?.with {

            patient = patientService.save(patient)

            prescriber = practitionerService.save(prescriber)

            prescribedMedications.each { prescribedMedication ->

                prescribedMedication?.with {
                    medication = goodService.findByIdentifiers(medication.identifiers)

                    dosageInstruction?.with {

                        doseQuantity?.with {
                            unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                        }

                        timing?.with {
                            repeat?.with {
                                duration?.with {
                                    unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                                }
                            }
                        }
                    }
                }
            }
        }

        prescriptionService.save(prescription)
    }

    @Override
    Prescription findByIdentifier(String identifier) {
        prescriptionService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Prescription> findAll() {
        prescriptionService.findAll()
    }
}
