package org.celllife.idart.common;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-15
 * Time: 14h06
 */
public class Measurement implements Serializable {

    private static final long serialVersionUID = -8881550184074440057L;

    private MeasurementType type;

    private Quantity value;

    /**
     * Taken on
     */
    private Date dateTaken;

    public Measurement() {
    }

    public static Measurement newMeasurement(MeasurementType type, Quantity value, Date dateTaken) {

        Measurement measurement = new Measurement();
        measurement.type = type;
        measurement.value = value;
        measurement.dateTaken = dateTaken;

        return measurement;
    }

    public MeasurementType getType() {
        return type;
    }

    public void setType(MeasurementType type) {
        this.type = type;
    }

    public Quantity getValue() {
        return value;
    }

    public void setValue(Quantity value) {
        this.value = value;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;

        if (dateTaken != null ? !dateTaken.equals(that.dateTaken) : that.dateTaken != null) return false;
        if (type != that.type) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (dateTaken != null ? dateTaken.hashCode() : 0);
        return result;
    }
}
