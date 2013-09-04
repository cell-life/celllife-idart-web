package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 16h52
 */
class Label {

    String value

    static Label valueOf(String value) {
        new Label(value: value)
    }

    static Label label(String value) {
        new Label(value: value)
    }

    @JsonValue
    String getValue() {
        return value
    }

    void setValue(String value) {
        this.value = value
    }
}
