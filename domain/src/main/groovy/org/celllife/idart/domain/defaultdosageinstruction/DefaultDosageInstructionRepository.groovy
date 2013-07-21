package org.celllife.idart.domain.defaultdosageinstruction;


/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h29
 */
public interface DefaultDosageInstructionRepository {

    DefaultDosageInstruction findOneByMedicationIdentifier(String medicationIdentifierSystem,
                                                           String medicationIdentifierValue);

    Iterable<DefaultDosageInstruction> findByIdentifier(String medicationIdentifierValue);

}
