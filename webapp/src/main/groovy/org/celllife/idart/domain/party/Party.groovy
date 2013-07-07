package org.celllife.idart.domain.party

import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.concept.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 13h45
 */
@Mixin([Identifiable])
abstract class Party implements Persistable {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    /**
     * Classified into
     */
    Set<PartyClassificationApplication> classifications

}
