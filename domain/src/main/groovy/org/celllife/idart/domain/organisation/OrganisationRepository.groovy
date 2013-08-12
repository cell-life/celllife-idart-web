package org.celllife.idart.domain.organisation

import org.celllife.idart.common.PartyIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface OrganisationRepository {

    Organisation save(Organisation organisation)

    Organisation findOne(PartyIdentifier partyIdentifier)

}
