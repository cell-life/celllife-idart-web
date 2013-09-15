package org.celllife.idart.relationship.systemfacility

import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.SystemId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 15h02
 */
interface SystemFacilityRepository {

    SystemFacility save(SystemFacility systemFacility)

    SystemFacility findBySystemFacilityRelationshipValid(SystemId system,
                                                         FacilityId facility,
                                                         SystemFacility.Relationship relationship,
                                                         Date validDate)

    Iterable<SystemFacility> findBySystemRelationshipValid(SystemId system,
                                                           SystemFacility.Relationship relationship,
                                                           Date validDate)

    Iterable<SystemFacility> findByFacilityRelationshipValid(FacilityId facility,
                                                             SystemFacility.Relationship relationship,
                                                             Date validDate)
}
