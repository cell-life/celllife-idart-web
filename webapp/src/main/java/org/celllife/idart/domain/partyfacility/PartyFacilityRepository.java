package org.celllife.idart.domain.partyfacility;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 09h53
 */
@RestResource(path = "partyFacilities")
public interface PartyFacilityRepository extends PagingAndSortingRepository<PartyFacility, Long> {

    @Query("select partyFacility " +
            "from PartyFacility partyFacility " +
            "where partyFacility.facility.id = :facilityPk")
    List<PartyFacility> findByClinicId(@Param("facilityPk") Long facilityPk);

    @Query("select partyFacility " +
            "from PartyFacility partyFacility " +
            "where partyFacility.party.pk = :partyPk and partyFacility.facility.pk = :facilityPk")
    PartyFacility findOneByPartyPkAndFacilityPk(@Param("partyPk") Long partyPk,
                                                @Param("facilityPk") Long facilityPk);

}
