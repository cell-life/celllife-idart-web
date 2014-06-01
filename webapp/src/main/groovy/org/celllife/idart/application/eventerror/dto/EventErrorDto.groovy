package org.celllife.idart.application.eventerror.dto

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.sql.Blob

import javax.persistence.Transient

import org.celllife.idart.domain.eventerror.EventError


/**
 * The Data Transfer Object for the EventError entity
 */
@ToString
@EqualsAndHashCode
class EventErrorDto implements Serializable {

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
    EventError.EventType eventType

    /**
     * The event's UUID
     */
    String eventUuid
}
