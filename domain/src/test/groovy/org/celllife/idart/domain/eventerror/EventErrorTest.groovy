package org.celllife.idart.domain.eventerror

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.junit.Assert
import org.junit.Test

class EventErrorTest {

    @Test
    def void testSerializationDispensation() throws Exception {
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
            eventUuid = randomUuid
        }

        // test serialization
        ee.setUnserializedEventObject(event)
        Object obj = ee.getDeserializedEventObject()
        
        Assert.assertTrue(obj instanceof DispensationEvent)
        DispensationEvent event1 = (DispensationEvent)obj
        Assert.assertEquals(event, event1)
    }

    @Test
    def void testSerializationPrescription() throws Exception {
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
            eventUuid = randomUuid
        }

        // test serialization
        ee.setUnserializedEventObject(event)
        Object obj = ee.getDeserializedEventObject()
        
        Assert.assertTrue(obj instanceof PrescriptionEvent)
        PrescriptionEvent event1 = (PrescriptionEvent)obj
        Assert.assertEquals(event, event1)
    }
}
