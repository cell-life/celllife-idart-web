package org.celllife.idart.infrastructure.springdata.partyfacility;

import org.celllife.idart.domain.partyfacility.PartyFacility;
import org.celllife.idart.domain.partyfacility.PartyFacilityRepository;
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
public interface SpringDataPartyFacilityRepository extends PartyFacilityRepository, PagingAndSortingRepository<PartyFacility, Long> {

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
