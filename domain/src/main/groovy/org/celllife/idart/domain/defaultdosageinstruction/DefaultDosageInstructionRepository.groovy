package org.celllife.idart.domain.defaultdosageinstruction

import javax.annotation.Generated;


/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h29
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DefaultDosageInstructionRepository {

    DefaultDosageInstruction findOneByIdentifier(String identifierSystem, String identifierValue);

    Iterable<DefaultDosageInstruction> findByIdentifier(String medicationIdentifierValue);

}
