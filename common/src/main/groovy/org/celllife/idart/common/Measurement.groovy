package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 14h06
 */
@EqualsAndHashCode
class Measurement {

    MeasurementType type

    Quantity value

    /**
     * Taken on
     */
    Date dateTaken

    static Measurement newMeasurement(MeasurementType type, Quantity value, Date dateTaken) {
        new Measurement(type: type, value: value, dateTaken: dateTaken)
    }
}
