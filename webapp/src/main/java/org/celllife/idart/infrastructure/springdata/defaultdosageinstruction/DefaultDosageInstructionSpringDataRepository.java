package org.celllife.idart.domain.defaultdosageinstruction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 17h29
 */
@RestResource(path = "defaultDosageInstructions")
public interface DefaultDosageInstructionSpringDataRepository extends DefaultDosageInstructionRepository,  CrudRepository<DefaultDosageInstruction, Long> {

    @Query("select defaultDosageInstruction " +
            "from DefaultDosageInstruction defaultDosageInstruction " +
            "join defaultDosageInstruction.medication medication " +
            "join medication.identifiers medicationIdentifier " +
            "where medicationIdentifier.system = :medicationIdentifierSystem " +
            "and medicationIdentifier.value = :medicationIdentifierValue")
    DefaultDosageInstruction findOneByMedicationIdentifier(@Param("medicationIdentifierSystem") String medicationIdentifierSystem,
                                                           @Param("medicationIdentifierValue") String medicationIdentifierValue);

    @Query("select defaultDosageInstruction " +
            "from DefaultDosageInstruction defaultDosageInstruction " +
            "join defaultDosageInstruction.medication medication " +
            "join medication.identifiers medicationIdentifier " +
            "where medicationIdentifier.value = :medicationIdentifierValue")
    Iterable<DefaultDosageInstruction> findByIdentifier(@Param("medicationIdentifierValue") String medicationIdentifierValue);

}
