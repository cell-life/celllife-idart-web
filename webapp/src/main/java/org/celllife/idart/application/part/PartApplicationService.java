package org.celllife.idart.application.part;

import org.celllife.idart.domain.common.Identifier;
import org.celllife.idart.domain.part.Part;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 04h47
 */
public interface PartApplicationService {

    Part findByIdentifiers(Set<Identifier> identifiers);

}