package org.celllife.idart.application.organisation.dto

import org.celllife.idart.domain.organisation.InformalOrganisation
import org.celllife.idart.domain.organisation.LegalOrganisation
import org.celllife.idart.domain.organisation.Organisation

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
class OrganisationDtoAssembler {

    static Organisation toOrganisation(OrganisationDto organisationDto) {
        switch (organisationDto.class) {
            case LegalOrganisationDto:
                return toLegalOrganisation(organisationDto as LegalOrganisationDto)
            case InformalOrganisationDto:
                return toInformalOrganisation(organisationDto as InformalOrganisationDto)
            default:
                throw new UnsupportedOrganisationDtoType(organisationDto.class)
        }
    }

    static LegalOrganisation toLegalOrganisation(LegalOrganisationDto legalOrganisationDto) {

        def legalOrganisation = new LegalOrganisation()
        legalOrganisation.with {

            name = legalOrganisationDto.name
            taxRegistrationNumber = legalOrganisationDto.taxRegistrationNumber
            classifications = legalOrganisationDto.classifications
            contactMechanisms = legalOrganisationDto.contactMechanisms
        }

        legalOrganisation
    }

    static InformalOrganisation toInformalOrganisation(InformalOrganisationDto informalOrganisationDto) {

        def informalOrganisation = new InformalOrganisation()
        informalOrganisation.with {

            name = informalOrganisationDto.name
            classifications = informalOrganisationDto.classifications
            contactMechanisms = informalOrganisationDto.contactMechanisms
        }

        informalOrganisation
    }

    static OrganisationDto toOrganisationDto(Organisation organisation) {
        switch (organisation.class) {
            case LegalOrganisation:
                return toLegalOrganisationDto(organisation as LegalOrganisation)
            case InformalOrganisationDto:
                return toInformalOrganisationDto(organisation as InformalOrganisation)
            default:
                throw new UnsupportedOrganisationType(organisation.class)
        }
    }


    static LegalOrganisationDto toLegalOrganisationDto(LegalOrganisation legalOrganisation) {

        def legalOrganisationDto = new LegalOrganisationDto()
        legalOrganisationDto.with {

            name = legalOrganisation.name
            taxRegistrationNumber = legalOrganisation.taxRegistrationNumber
            classifications = legalOrganisation.classifications
            contactMechanisms = legalOrganisation.contactMechanisms
        }

        legalOrganisationDto
    }

    static InformalOrganisationDto toInformalOrganisationDto(InformalOrganisation informalOrganisation) {

        def informalOrganisationDto = new InformalOrganisationDto()
        informalOrganisationDto.with {

            name = informalOrganisation.name
            classifications = informalOrganisation.classifications
            contactMechanisms = informalOrganisation.contactMechanisms
        }

        informalOrganisationDto
    }
}
