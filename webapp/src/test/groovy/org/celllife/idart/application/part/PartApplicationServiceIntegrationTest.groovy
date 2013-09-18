package org.celllife.idart.application.part

import org.celllife.idart.application.part.dto.CompoundDto
import org.celllife.idart.application.part.dto.DrugDto
import org.celllife.idart.common.Identifiers
import org.celllife.idart.domain.part.PartRepository
import org.celllife.idart.test.TestConfiguration
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.data.repository.CrudRepository
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.inject.Inject

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.PartType.COMPOUND
import static org.celllife.idart.common.PartType.DRUG
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.junit.Assert.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-17
 * Time: 20h40
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = TestConfiguration)
class PartApplicationServiceIntegrationTest {

    @Inject PartApplicationService partApplicationService

    @Inject PartRepository partRepository

    @Before
    public void setUp() throws Exception {

        [partRepository].each { repository ->
            ((CrudRepository) repository).deleteAll()
        }

    }

    @Test
    public void shouldFindByType() throws Exception {

        def compoundDto = new CompoundDto()
        compoundDto.with {
            identifiers = Identifiers.newIdentifiers(IDART_WEB, "99999999")
        }
        partApplicationService.save(compoundDto)

        def drugDto = new DrugDto()
        drugDto.with {
            identifiers = Identifiers.newIdentifiers(IDART_WEB, "99999998")
        }
        partApplicationService.save(drugDto)

        def partDtos = partApplicationService.findByType(COMPOUND)
        assertEquals(1, partDtos.size())
        assertTrue(partDtos.first() instanceof CompoundDto)
        assertEquals("99999999", getIdentifierValue(partDtos.first().identifiers, IDART_WEB.id))

        partDtos = partApplicationService.findByType(DRUG)
        assertEquals(1, partDtos.size())
        assertTrue(partDtos.first() instanceof DrugDto)
        assertEquals("99999998", getIdentifierValue(partDtos.first().identifiers, IDART_WEB.id))
    }
}
