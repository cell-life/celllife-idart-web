package org.celllife.idart.domain.partyfacility;


import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 09h53
 */
public interface PartyFacilityRepository {

    List<PartyFacility> findByClinicId(Long facilityPk);

    PartyFacility findOneByPartyPkAndFacilityPk(Long partyPk,
                                                Long facilityPk);

}
