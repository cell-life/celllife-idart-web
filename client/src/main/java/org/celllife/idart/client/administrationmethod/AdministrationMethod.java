package org.celllife.idart.client.administrationmethod;

import org.celllife.idart.common.AdministrationMethodCode;

import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class AdministrationMethod implements Serializable {

    public AdministrationMethodCode code;

    public String name;

    public String description;

    public AdministrationMethod() {
    }
}
