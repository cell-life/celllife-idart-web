package org.celllife.idart.application.practitioner.dto

import org.celllife.idart.domain.practitioner.Practitioner

import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
@Named class PractitionerDtoAssembler {

    Practitioner toPractitioner(PractitionerDto practitionerDto) {
        copyToPractitioner(practitionerDto, new Practitioner())
    }

    Practitioner copyToPractitioner(PractitionerDto practitionerDto, Practitioner practitioner) {

        practitioner.with {

            type = practitionerDto.type

            if (practitionerDto.valid != null) {
                valid = practitionerDto.valid
            }
        }

        practitioner
    }

    PractitionerDto toPractitionerDto(Practitioner practitioner) {

        def practitionerDto = new PractitionerDto()
        practitionerDto.with {

            type = practitioner.type

            if (practitionerDto.valid != null) {
                valid = practitionerDto.valid
            }
        }

        practitionerDto
    }
}
