package org.celllife.idart.application.defaultdosageinstruction;

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h42
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DefaultDosageInstructionResourceService {

    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction);

    DefaultDosageInstruction findByIdentifier(String identifier);

    Iterable<DefaultDosageInstruction> findAll();

}