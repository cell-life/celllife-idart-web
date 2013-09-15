package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.identifiable.IdentifiableSeqeuence

import javax.inject.Inject
import javax.inject.Named

import static java.lang.String.format
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PATIENT
import static org.celllife.idart.domain.patient.PatientEvent.EventType.SAVED
import static org.celllife.idart.domain.patient.PatientEvent.newPatientEvent

/**
 */

@Named class PatientServiceImpl implements PatientService {

    @Inject PatientRepository patientRepository

    @Inject PatientValidator patientValidator

    @Inject PatientEventPublisher patientEventPublisher

    @Inject IdentifiableSeqeuence identifiableSeqeuence

    @Override
    Patient save(Patient patient) {

        def existingPatient = null

        if (patient.id != null) {
            existingPatient = patientRepository.findOne(patient.id)
        } else {
            def value = identifiableSeqeuence.nextValue(PATIENT)
            patient.id = patientId(format("%08d", value))
        }

        if (existingPatient == null) {
            existingPatient = patient
        } else {
            existingPatient.merge(patient)
        }

        patientValidator.validate(existingPatient)

        patientEventPublisher.publish(newPatientEvent(existingPatient, SAVED))

        patientRepository.save(existingPatient)
    }

    @Override
    Patient findByPatientId(PatientId patientId) {

        def patient = patientRepository.findOne(patientId)

        if (patient == null) {
            throw new PatientNotFoundException("Could not find Patient with Patient Id [${ patientId}]")
        }

        patient
    }
}
