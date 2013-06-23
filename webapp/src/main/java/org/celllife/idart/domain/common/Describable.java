package org.celllife.idart.domain.common;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 23h11
 */
public interface Describable {

    String getDescription();

    void setDescription(String description);

    void addDescription(String description);

    void addDescription(String locale, String description);
}
