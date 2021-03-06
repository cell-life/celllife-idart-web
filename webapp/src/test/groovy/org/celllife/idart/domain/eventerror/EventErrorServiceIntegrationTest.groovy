package org.celllife.idart.domain.eventerror

import javax.inject.Inject

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.test.TestConfiguration
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional


@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = true)
class EventErrorServiceIntegrationTest {

    @Inject EventErrorService eventErrorService

    @Test
    def void testSaveAndRetrieve() throws Exception {
        // setup the event + eventerror
        UUID randomUuid = UUID.randomUUID()
        DispensationEvent event = new DispensationEvent()
        event.with {
            timestamp = new Date()
            username = "dagmar"
            uuid = randomUuid
            type = DispensationEvent.EventType.SAVED
            dispensation = new Dispensation()
        }
        EventError ee = new EventError()
        ee.with {
            pk = 1
            datetime = new Date()
            retryCount = 2
            eventType = EventError.EventType.DISPENSATION_EVENT
            eventUuid = randomUuid.toString()
        }
        ee.setUnserializedEventObject(event)

        // save
        eventErrorService.save(ee);

        // retrieve
        EventError ee2 = eventErrorService.findByEventUuid(randomUuid.toString())

        // test
        Assert.assertNotNull(ee2)
        Assert.assertEquals(ee.eventUuid, ee2.eventUuid)
    }

}
