package org.celllife.idart.application.part

import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.PartType.COMPOUND
import static org.celllife.idart.common.PartType.DRUG
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.junit.Assert.*

import javax.inject.Inject

import org.celllife.idart.application.part.dto.CompoundDto
import org.celllife.idart.application.part.dto.DrugDto
import org.celllife.idart.common.PartId
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional


@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = TestConfiguration)
@Transactional
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = true)
class PartApplicationServiceIntegrationTest {

    @Inject PartApplicationService partApplicationService

    @Test
    public void shouldFindByType() throws Exception {

        def compoundDto = new CompoundDto()
        compoundDto.with {
            identifiers = newIdentifiers("99999999")
        }
        partApplicationService.save(compoundDto)

        def drugDto = new DrugDto()
        drugDto.with {
            identifiers = newIdentifiers("99999998")
        }
        partApplicationService.save(drugDto)

        assertTrue(partApplicationService.exists(PartId.valueOf("99999999")))
        assertTrue(partApplicationService.exists(PartId.valueOf("99999998")))
    }
}
