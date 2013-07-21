package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 22h00
 */
interface DefaultDosageInstructionService {

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction)

    Iterable<DefaultDosageInstruction> findAll()

    DefaultDosageInstruction findByIdentifiers(Set<Identifier> medicationIdentifiers)

    DefaultDosageInstruction findByIdentifier(String medicationIdentifier)
}