package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier

import javax.inject.Inject
import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h57
 */
@Named class IdentifiableServiceImpl implements IdentifiableService {

    @Inject IdentifiableRepository identifiableRepository

    @Inject IdentifiableSeqeuence identifiableSeqeuence

    @Override
    Identifiable resolveIdentifiable(IdentifiableType identifiableType, Set<Identifier> identifiers) {

        def existingIdentifiable = doFindByIdentifiers(identifiableType, identifiers)

        if (existingIdentifiable == null) {
            existingIdentifiable = new Identifiable(type: identifiableType)

            existingIdentifiable.addIdentifier(identifiableSeqeuence.nextValue(identifiableType))
        }

        existingIdentifiable.addIdentifiers(identifiers)

        identifiableRepository.save(existingIdentifiable)

        return existingIdentifiable
    }

    @Override
    Boolean exists(IdentifiableType type, Set<Identifier> identifiers) {
        doFindByIdentifiers(type, identifiers) != null
    }

    Identifiable doFindByIdentifiers(IdentifiableType identifiableType, Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def existingIdentifiable = identifiableRepository
                    .findByTypeAndSystemAndValue(identifiableType, identifier.system, identifier.value)

            if (existingIdentifiable != null) {
                return existingIdentifiable
            }
        }

        return null

    }
}
