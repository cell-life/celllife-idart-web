package org.celllife.idart.domain.product

import groovy.transform.ToString


/**
 * Product Domain Event
 */
@ToString
class ProductEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Product product

    static ProductEvent newProductEvent(Product product, ProductEvent.EventType eventType) {

        new ProductEvent(
            product: product,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
