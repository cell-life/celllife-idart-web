package org.celllife.idart.domain.defaultdosageinstruction
/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h29
 */
//@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DefaultDosageInstructionRepository {

    DefaultDosageInstruction findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<DefaultDosageInstruction> findByIdentifier(String medicationIdentifierValue)

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction)

}
