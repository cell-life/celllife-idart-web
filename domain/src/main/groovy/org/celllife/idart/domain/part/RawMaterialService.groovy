package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
public interface RawMaterialService {

    RawMaterial findByIdentifiers(Iterable<Identifier> identifiers)

}