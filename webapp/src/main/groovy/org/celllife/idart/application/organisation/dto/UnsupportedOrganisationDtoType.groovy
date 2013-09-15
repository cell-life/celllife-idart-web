package org.celllife.idart.application.organisation.dto

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h26
 */
class UnsupportedOrganisationDtoType extends RuntimeException {

    UnsupportedOrganisationDtoType(Class<OrganisationDto> organisationDtoClass) {
        super(organisationDtoClass.toString())
    }
}
