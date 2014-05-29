package org.celllife.idart.domain.identifiable

import org.celllife.idart.common.IdentifiableType
import org.celllife.idart.common.Identifier

/**
 * Service to retrieve identifiers. Each entity can have multiple identifiers (and usually at least two - the IDART_WEB system identifier and the system's own identifier)
 */
public interface IdentifiableService {

    /**
     * Retrieves an Identifiable object and if one doesn't exist, create it.
     * @param type IdentifiableType that indicates whether the entity is a Dispensation, Prescription, etc
     * @param identifiers Set of Identifiers that indicate the actual ID and the owner of the ID (e.g. IDART_WEB or the user's own identifier)
     * @return Identifiable, will never be null
     */
    Identifiable resolveIdentifiable(IdentifiableType type, Set<Identifier> identifiers)

    /**
     * Searches for the Identifiable object and indicates if it exists or not
     * @param type IdentifiableType that indicates whether the entity is a Dispensation, Prescription, etc
     * @param identifiers Set of Identifiers that indicate the actual ID and the owner of the ID (e.g. IDART_WEB or the user's own identifier)
     * @return true if the identifier was found, false otherwise
     */
    Boolean exists(IdentifiableType type, Set<Identifier> identifiers)
    
    /**
     * Searches for an identifiable object and returns the found Identifiable
     * @param type IdentifiableType that indicates whether the entity is a Dispensation, Prescription, etc
     * @param identifiers Set of Identifiers that indicate the actual ID and the owner of the ID (e.g. IDART_WEB or the user's own identifier)
     * @return Identifiable, false if no matches found
     */
    Identifiable findByIdentifiers(IdentifiableType identifiableType, Set<Identifier> identifiers)
}