package org.celllife.idart.domain.identifiable
/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h56
 */
public interface IdentifiableService {

    Identifiable save(Identifiable identifiable)

    Identifiable findByIdentifiers(IdentifiableType type, Set<Identifier> identifiers)
}