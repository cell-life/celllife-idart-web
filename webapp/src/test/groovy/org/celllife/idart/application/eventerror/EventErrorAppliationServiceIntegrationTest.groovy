package org.celllife.idart.application.eventerror

import javax.inject.Inject

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.domain.eventerror.EventError
import org.celllife.idart.domain.eventerror.EventErrorService
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.celllife.idart.test.TestConfiguration
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
class EventErrorAppliationServiceIntegrationTest {
    
    @Inject EventErrorService eventErrorService
    @Inject EventErrorApplicationService eventErrorApplicationService

    @Test
    def void testReprocessDispensationEvent() throws Exception {
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

        EventError savedEe = eventErrorService.save(ee);
        
        List<Long> ids = new ArrayList<Long>()
        ids.add(savedEe.pk)
        eventErrorApplicationService.reprocess(ids)
        
        EventError reprocessedEe = eventErrorService.findByEventErrorId(savedEe.pk)
        Assert.assertNotNull(reprocessedEe) // expecting it to fail again
        Assert.assertEquals(savedEe.retryCount+1, reprocessedEe.retryCount)
        Assert.assertNotNull(reprocessedEe.errorMessage)
    }

    @Test
    def void testReprocessPrescriptionEvent() throws Exception {
        // setup the event + eventerror
        UUID randomUuid = UUID.randomUUID()
        PrescriptionEvent event = new PrescriptionEvent()
        event.with {
            timestamp = new Date()
            username = "dagmar"
            uuid = randomUuid
            type = PrescriptionEvent.EventType.SAVED
            prescription = new Prescription()
        }
        EventError ee = new EventError()
        ee.with {
            pk = 1
            datetime = new Date()
            retryCount = 2
            eventType = EventError.EventType.PRESCRIPTION_EVENT
            eventUuid = randomUuid.toString()
        }
        ee.setUnserializedEventObject(event)

        EventError savedEe = eventErrorService.save(ee);
        
        List<Long> ids = new ArrayList<Long>()
        ids.add(savedEe.pk)
        eventErrorApplicationService.reprocess(ids)
        
        EventError reprocessedEe = eventErrorService.findByEventErrorId(savedEe.pk)
        Assert.assertNotNull(reprocessedEe) // expecting it to fail again
        Assert.assertEquals(savedEe.retryCount+1, reprocessedEe.retryCount)
        Assert.assertNotNull(reprocessedEe.errorMessage)
    }
}
