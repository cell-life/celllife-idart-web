package org.celllife.idart.domain.assignment;

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
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {

    @Query("select assignment from Assignment assignment where assignment.clinic.id = :clinicId")
    List<Assignment> findByClinicId(@Param("clinicId") Long clinicId);

    @Query("select assignment from Assignment assignment " +
            "where assignment.doctor.pk = :doctorId and assignment.clinic.id = :clinicId")
    Assignment findOneByDoctorIdAndClinicId(@Param("doctorId") Long doctorId, @Param("clinicId") Long clinicId);

}
