package org.celllife.idart.application.encounter.dto

import org.celllife.idart.domain.encounter.Encounter
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterDtoAssembler {

    static Encounter toEncounter(EncounterDto encounterDto) {

        def encounter = new Encounter()
        encounter.with {

        }

        encounter
    }

    static EncounterDto toEncounterDto(Encounter encounter) {

        def encounterDto = new EncounterDto()
        encounterDto.with {

        }

        encounterDto
    }
}
