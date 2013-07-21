package org.celllife.idart.application.part;

import org.celllife.idart.domain.common.Identifier;
import org.celllife.idart.domain.part.Part;

import javax.annotation.Generated;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PartApplicationService {

    Part findByIdentifiers(Set<Identifier> identifiers);

}