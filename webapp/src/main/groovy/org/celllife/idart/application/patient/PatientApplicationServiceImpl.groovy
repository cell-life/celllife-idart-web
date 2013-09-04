package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.application.patient.dto.PatientDtoAssembler.copyToPatient
import static org.celllife.idart.application.patient.dto.PatientDtoAssembler.toPatient
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PatientId.patientId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PATIENT
import static org.celllife.idart.domain.identifiable.Identifier.newIdentifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Named class PatientApplicationServiceImpl implements PatientApplicationService {

    @Inject PatientService patientService

    @Inject PersonApplicationService personApplicationService

    @Inject IdentifiableService identifiableService

    @Override
    Patient findByPatientId(PatientId patientId) {
        patientService.findByPatientId(patientId)
    }

    @Override
    Patient save(Patient patient) {
        patientService.save(patient)
    }

    @Override
    PatientId save(PatientDto patientDto) {

        def personDto = patientDto.person

        def identifiable = identifiableService.findByIdentifiers(PATIENT, patientDto.identifiers)
        if (identifiable != null) {

            def patientId = patientId(identifiable.getIdentifier(IDART).value)
            def patient = patientService.findByPatientId(patientId)

            def person = personApplicationService.findByPersonId(patient.person)
            if (person != null) {

                // Scenario 1 - Both Patient and Person exists

                personApplicationService.save(personDto)

                copyToPatient(patientDto, patient)
                patient = patientService.save(patient)

                patient.id

            } else {

                // Scenario 2 - Patient exists but Person does not

                // How did we manage to create a Patient without a Person... very very bad
                throw new PatientWithoutAPersonException("Something bad happened")
            }

        } else {

            // Scenario 3 - Patient does not exist, but Person does

            // Scenario 4 - Patient and Person don't exist

            def patient = toPatient(patientDto)
            patient.person = personApplicationService.save(personDto)

            patient = patientService.save(patient)

            identifiable = new Identifiable(type: PATIENT, identifiers: patientDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, patient.id.value))
            identifiableService.save(identifiable)

            patient.id
        }
    }
}
