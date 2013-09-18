package org.celllife.idart.application.encounter.dto

import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.encounter.Participant

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class EncounterDtoAssembler {

    @Inject PractitionerApplicationService practitionerApplicationService

    @Inject PatientApplicationService patientApplicationService

    @Inject FacilityApplicationService facilityApplicationService

    Encounter toEncounter(EncounterDto encounterDto) {

        def encounter = new Encounter()
        encounter.with {
            participants = encounterDto.participants?.collect { participantDto ->
                new Participant(
                        type: participantDto.type,
                        practitioner: practitionerApplicationService.findByIdentifiers(participantDto.practitioner)
                )
            }

            if (encounterDto.patient != null) {
                patient = patientApplicationService.findByIdentifiers(encounterDto.patient)
            }

            if (encounterDto.facility != null) {
                facility = facilityApplicationService.findByIdentifiers(encounterDto.facility)
            }

            startedAt = encounterDto.startedAt
            duration = encounterDto.duration
        }

        encounter
    }

    EncounterDto toEncounterDto(Encounter encounter) {

        def encounterDto = new EncounterDto()
        encounterDto.with {

            participants = encounter.participants?.collect { participant ->
                new ParticipantDto(
                        type: participant.type,
                        practitioner: practitionerApplicationService.findByPractitionerId(participant.practitioner).identifiers
                )
            }

            if (encounter.patient != null) {
                patient = patientApplicationService.findByPatientId(encounter.patient)?.identifiers
            }

            if (encounter.facility != null) {
                facility = facilityApplicationService.findByFacilityId(encounter.facility)?.identifiers
            }

            startedAt = encounter.startedAt
            duration = encounter.duration
        }

        encounterDto
    }
}
