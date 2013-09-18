package org.celllife.idart.common;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Party Classification Code
 *
 */
public class PartClassificationCode implements Serializable {

    /**
     * Value
     */
    private String value;

    /**
     * Type
     */
    private PartClassificationType type;

    public static PartClassificationCode valueOf(String string) {

        Pattern pattern = Pattern.compile("([^-]*)-([0-9]*)");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new RuntimeException("Unknown PartClassificationCode [" + string + "]");
        }

        return partClassificationCode(matcher.group(2), PartClassificationType.valueOf(matcher.group(1)));
    }

    public static PartClassificationCode partClassificationCode(String value, PartClassificationType type) {

        PartClassificationCode partClassificationCode = new PartClassificationCode();
        partClassificationCode.value = value;
        partClassificationCode.type = type;

        return partClassificationCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PartClassificationType getType() {
        return type;
    }

    public void setType(PartClassificationType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartClassificationCode that = (PartClassificationCode) o;

        if (type != that.type) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s-%s", type, value);
    }
}
