package org.celllife.idart.infrastructure.springdata.assignment;

import org.celllife.idart.domain.assignment.Assignment;
import org.celllife.idart.domain.assignment.AssignmentRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h56
 */
@RestResource(path = "assignments")
public interface SpringDataAssignmentRepository extends AssignmentRepository, CrudRepository<Assignment, Long> {

    @Query("select assignment " +
            "from Assignment assignment " +
            "where assignment.clinic.id = :clinicId")
    List<Assignment> findByClinicId(@Param("clinicId") Long clinicId);

    @Query("select assignment " +
            "from Assignment assignment " +
            "where assignment.practitioner.pk = :practitionerPk and assignment.clinic.pk = :clinicPk")
    Assignment findOneByPractitionerPkAndClinicPk(@Param("practitionerPk") Long practitionerPk,
                                                  @Param("clinicPk") Long clinicPk);

}
