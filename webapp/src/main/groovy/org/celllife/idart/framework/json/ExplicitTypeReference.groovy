package org.celllife.idart.framework.json

import com.fasterxml.jackson.core.type.TypeReference

import java.lang.reflect.Type

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 09h59
 */
class ExplicitTypeReference extends TypeReference<Object> {

    def Type type

    ExplicitTypeReference(Type type) {
        this.type = type;
    }
}
