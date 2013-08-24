package org.celllife.idart.domain.organisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.party.Party

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h50
 */
abstract class Organisation extends Party {

    /**
     * Identified by
     */
    OrganisationId id

    String name

}
