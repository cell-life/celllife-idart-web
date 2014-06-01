package org.celllife.idart.domain.eventerror

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.sql.Blob

import javax.sql.rowset.serial.SerialBlob

/**
 * Log for Events that result in an error. For example, if a PrescriptionEvent fails, then an EventError is
 * created. This will be used for monitoring and for later retries.
 */
@ToString
@EqualsAndHashCode
class EventError implements Serializable {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Date and time of the original event
     */
    Date datetime

    /**
     * The number of times this event has been retried
     */
    Integer retryCount

    /**
     * The relevant error message related to the failure
     */
    String errorMessage

    /**
     * Indicates the type of event
     */
    EventType eventType
    
    enum EventType {
        PRESCRIPTION_EVENT,
        DISPENSATION_EVENT
    }

    /**
     * The event's UUID
     */
    String eventUuid

    /**
     * A serialized copy of the original Event object
     */
    Blob eventObject


    def merge(EventError that) {

        if (that == null) {
            return
        }

        this.errorMessage = that.errorMessage
        this.datetime = that.datetime
        this.retryCount = that.retryCount
        this.eventType = that.eventType
        this.eventUuid = that.eventUuid
        this.eventObject = that.eventObject
    }

    /**
     * Deserializes this event object
     * @return Object, can be null
     */
    def getDeserializedEventObject() {
        Object obj = null
        if (eventObject != null) {
            ByteArrayInputStream bais = (ByteArrayInputStream)eventObject.getBinaryStream()
            try {
                ObjectInputStream ins = new ObjectInputStream(bais)
                try {
                    obj = ins.readObject()
                } finally {
                    try {
                        ins.close()
                    } catch (Exception e) { 
                        // close quietly 
                    }
                }
            } finally {
                try {
                    bais.closeQuietly()
                } catch (Exception e) {
                    // close quietly
                }
            }
        }
        return obj
    }

    /**
     * Serializes the specified object and then sets as the eventObject
     * @param eventObject Object to serialize
     */
    def setUnserializedEventObject(Object newEventObject) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos)
            try {
                oos.writeObject(newEventObject)
                oos.flush()
            } finally {
                try {
                    oos.closeQuietly()
                } catch (Exception e) {
                    // close quietly
                }
            }
        } finally {
            try {
                baos.closeQuietly()
            } catch (Exception e) {
                // close quietly
            }
        }
        byte[] bytes = baos.toByteArray()
        eventObject = new SerialBlob(bytes)
    }
}
