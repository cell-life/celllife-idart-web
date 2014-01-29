package org.celllife.idart.application.part

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.SystemId.systemId
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.Systems.PREHMIS
import static org.junit.Assert.*

import javax.inject.Inject

import org.celllife.idart.application.facility.FacilityApplicationService
import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.part.dto.AtcCodeDto
import org.celllife.idart.domain.facility.FacilityRepository
import org.celllife.idart.infrastructure.springdata.facility.SpringDataFacilityRepository
import org.celllife.idart.test.TestConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 20h40
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = TestConfiguration)
class AtcCodeApplicationServiceIntegrationTest {

	@Inject FacilityApplicationService facilityApplicationService
	
	@Inject FacilityRepository facilityRepository

    @Inject AtcCodeApplicationService atcCodeApplicationService

	@Inject ObjectMapper objectMapper

	@Before
	public void setUp() throws Exception {

		((SpringDataFacilityRepository) facilityRepository).deleteAll()

	}

	@Test
	public void shouldFindByFacility() throws Exception {

		def facility = new FacilityDto()
		facility.with {
			identifiers = [
					newIdentifier(PREHMIS.id, "WES")
			]
		}

		def facilityId = facilityApplicationService.save(facility)

		def atcCodes = atcCodeApplicationService.findByFacility(facilityId)

		atcCodes.each { atcCode ->
			println toJson(atcCode)
		}
	}

	def String toJson(AtcCodeDto atcCode) {
		objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(atcCode)
	}
}
