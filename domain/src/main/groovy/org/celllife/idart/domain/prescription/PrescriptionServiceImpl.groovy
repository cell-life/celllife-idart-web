package org.celllife.idart.domain.prescription

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.celllife.idart.domain.prescription.Prescriptions.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 21h49
 */
@Service class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired PrescriptionRepository prescriptionRepository

    @Autowired PrescriptionSequence prescriptionSequence

    @Autowired PrescriptionValidator prescriptionValidator

    @Override
    Prescription save(Prescription newPrescription) {

        prescriptionValidator.validate(newPrescription)

        def existingPrescription = findByIdentifiers(newPrescription.identifiers)

        if (requiresIdartIdentifier(newPrescription, existingPrescription)) {
            newPrescription.addIdentifier(Prescription.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingPrescription == null) {
            existingPrescription = new Prescription()
        }

        existingPrescription.merge(newPrescription)

        prescriptionRepository.save(existingPrescription)
    }

    @Override
    Prescription findByIdentifiers(Set<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingPrescription = prescriptionRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingPrescription != null) {
                return existingPrescription
            }
        }

        null
    }

    @Override
    Prescription findByIdentifier(String identifier) {
        prescriptionRepository.findByIdentifier(identifier)
    }

    @Override
    Iterable<Prescription> findAll() {
        prescriptionRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format(IDART_PRESCRIPTION_IDENTIFIER_FORMAT, prescriptionSequence.nextValue())
    }

}
