package org.celllife.idart.domain.identifiable

import javax.inject.Inject
import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h57
 */
@Named class IdentifiableServiceImpl implements IdentifiableService {

    @Inject IdentifiableRepository identifiableRepository

    Identifiable save(Identifiable identifiable) {

        def existingIdentifiable = findByIdentifiers(identifiable.type, identifiable.identifiers)

        if (existingIdentifiable == null) {
            existingIdentifiable = new Identifiable(type: identifiable.type)
        }

        existingIdentifiable.addIdentifiers(identifiable.identifiers)

        identifiableRepository.save(existingIdentifiable)
    }

    Identifiable findByIdentifiers(IdentifiableType type, Set<Identifier> identifiers) {

        for (identifier in identifiers) {

            def identifiable =
                identifiableRepository.findByTypeAndAuthorityAndValue(type, identifier.authority, identifier.value)

            if (identifiable != null) {
                return identifiable
            }
        }

        return null
    }
}
