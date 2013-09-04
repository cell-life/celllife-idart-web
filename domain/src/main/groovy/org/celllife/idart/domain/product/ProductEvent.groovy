package org.celllife.idart.domain.product

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Product Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class ProductEvent {

    EventHeader header

    Product product

    static ProductEvent newProductEvent(Product product, ProductEvent.EventType eventType) {
        new ProductEvent(product: product, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
