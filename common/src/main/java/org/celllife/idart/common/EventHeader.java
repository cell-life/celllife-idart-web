package org.celllife.idart.common;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h34
 */
public final class EventHeader implements Serializable {

    private Date timestamp;

    private UUID uuid;

    private EventType type;

    private String username;

    public EventHeader() {
    }

    public static EventHeader newEventHeader(EventType type) {

        EventHeader header = new EventHeader();
        header.type = type;
        header.timestamp = new Date();
        header.uuid = UUID.randomUUID();

        return header;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
