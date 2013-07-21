package org.celllife.idart.infrastructure.springdata.defaultdosageinstruction;

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction;
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionRepository;
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
public interface SpringDataDefaultDosageInstructionRepository extends DefaultDosageInstructionRepository, CrudRepository<DefaultDosageInstruction, Long> {

    @Query("select defaultDosageInstruction " +
            "from DefaultDosageInstruction defaultDosageInstruction " +
            "join defaultDosageInstruction.medication medication " +
            "join medication.identifiers identifier " +
            "where identifier.system = :identifierSystem " +
            "and identifier.value = :identifierValue")
    DefaultDosageInstruction findOneByIdentifier(@Param("identifierSystem") String identifierSystem,
                                                 @Param("identifierValue") String identifierValue);

    @Query("select defaultDosageInstruction " +
            "from DefaultDosageInstruction defaultDosageInstruction " +
            "join defaultDosageInstruction.medication medication " +
            "join medication.identifiers identifier " +
            "where identifier.value = :identifierValue")
    Iterable<DefaultDosageInstruction> findByIdentifier(@Param("identifierValue") String identifierValue);

}
