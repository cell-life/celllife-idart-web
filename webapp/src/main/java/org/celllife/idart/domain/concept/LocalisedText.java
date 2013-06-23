package org.celllife.idart.domain.concept;

import com.google.common.base.Objects;
import org.celllife.idart.udm.common.ValueObject;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 19h34
 */
@Embeddable
public final class LocalisedText implements ValueObject {

    @NotNull
    private String locale;

    @NotNull
    private String value;

    public LocalisedText() {
    }

    public LocalisedText(String locale, String value) {
        this.locale = locale;
        this.value = value;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalisedText that = (LocalisedText) o;

        if (!locale.equals(that.locale)) return false;
        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locale.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("locale", locale)
                .add("value", value)
                .toString();
    }
}
