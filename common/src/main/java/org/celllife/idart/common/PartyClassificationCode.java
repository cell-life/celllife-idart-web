package org.celllife.idart.common;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Party Classification Code
 *
 */
public class PartyClassificationCode implements Serializable {

    private static final long serialVersionUID = -4741981453202438699L;

    /**
     * Value
     */
    private String value;

    /**
     * Type
     */
    private PartyClassificationType type;

    public static PartyClassificationCode valueOf(String string) {

        Pattern pattern = Pattern.compile("([^-]*)-([0-9]*)");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new RuntimeException("Unknown PartyClassificationCode [${string}]");
        }

        PartyClassificationCode partyClassificationCode = new PartyClassificationCode();
        partyClassificationCode.value = matcher.group(2);
        partyClassificationCode.type = PartyClassificationType.valueOf(matcher.group(1));

        return partyClassificationCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PartyClassificationType getType() {
        return type;
    }

    public void setType(PartyClassificationType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartyClassificationCode that = (PartyClassificationCode) o;

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
