package org.celllife.idart.domain.identifiable

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Implementation of the IdentifiableService.
 */
@Named class IdentifiableServiceImpl implements IdentifiableService {
    
    static final Logger LOGGER = LoggerFactory.getLogger(IdentifiableServiceImpl)

    @Inject IdentifiableRepository identifiableRepository

    @Inject IdentifiableSeqeuence identifiableSeqeuence

    @Override
    Identifiable resolveIdentifiable(IdentifiableType identifiableType, Set<Identifier> identifiers) {

        LOGGER.debug("Resolve by identifier "+identifiableType+" identifiers="+identifiers)
        def existingIdentifiable = findByIdentifiers(identifiableType, identifiers)

        if (existingIdentifiable == null) {
            LOGGER.debug("No existing identifier found, so creating a new one.")
            existingIdentifiable = new Identifiable(type: identifiableType)

            if (getIdentifierValue(identifiers, IDART_WEB.id) == null) {
                // if there is no IDART_WEB (our) identifier, generate and add one
                existingIdentifiable.addIdentifier(identifiableSeqeuence.nextValue(identifiableType))
            }
        } else {
            LOGGER.debug("Existing identifier found ("+existingIdentifiable+") so creating a new one.")
        }

        existingIdentifiable.addIdentifiers(identifiers)

        LOGGER.debug("saving new identifier "+existingIdentifiable)
        identifiableRepository.save(existingIdentifiable)

        return existingIdentifiable
    }

    @Override
    Boolean exists(IdentifiableType type, Set<Identifier> identifiers) {
        findByIdentifiers(type, identifiers) != null
    }

    @Override
    Identifiable findByIdentifiers(IdentifiableType identifiableType, Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            LOGGER.debug("Find by identifier "+identifiableType+" System="+identifier.system+" Identifier="+identifier.value)
            def existingIdentifiable = identifiableRepository
                    .findByTypeAndSystemAndValue(identifiableType, identifier.system, identifier.value)

            if (existingIdentifiable != null) {
                LOGGER.debug("Matched identifiable "+existingIdentifiable)
                return existingIdentifiable
            }
        }

        return null

    }
}
