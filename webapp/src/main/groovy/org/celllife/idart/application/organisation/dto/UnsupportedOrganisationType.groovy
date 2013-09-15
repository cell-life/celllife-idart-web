package org.celllife.idart.application.organisation.dto

import org.celllife.idart.domain.organisation.Organisation

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 13h26
 */
class UnsupportedOrganisationType extends RuntimeException {

    UnsupportedOrganisationType(Class<Organisation> organisationClass) {
        super(organisationClass.toString())
    }
}
