package org.celllife.idart.domain.assignment
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h56
 */
public interface AssignmentRepository {

    List<Assignment> findByClinicId(Long clinicId);

    Assignment findOneByPractitionerPkAndClinicPk(Long practitionerPk, Long clinicPk);

}
