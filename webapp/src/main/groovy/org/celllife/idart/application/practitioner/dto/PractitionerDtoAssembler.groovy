package org.celllife.idart.application.practitioner.dto

import org.celllife.idart.domain.practitioner.Practitioner

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
class PractitionerDtoAssembler {

    static Practitioner toPractitioner(PractitionerDto practitionerDto) {
        copyToPractitioner(practitionerDto, new Practitioner())
    }

    static copyToPractitioner(PractitionerDto practitionerDto, Practitioner practitioner) {

        practitioner.with {

            type = practitionerDto.type

            if (practitionerDto.valid != null) {
                valid = practitionerDto.valid
            }
        }

        practitioner
    }

    static PractitionerDto toPractitionerDto(Practitioner practitioner) {
        copyToPractitionerDto(practitioner, new PractitionerDto())
    }

    static copyToPractitionerDto(Practitioner practitioner, PractitionerDto practitionerDto) {

        practitionerDto.with {

            type = practitioner.type

            if (practitionerDto.valid != null) {
                valid = practitionerDto.valid
            }
        }

        practitionerDto
    }
}
