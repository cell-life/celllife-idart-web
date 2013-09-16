package org.celllife.idart.client.form;

import org.celllife.idart.common.FormCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 12h24
 */
public final class Form implements Serializable {

    public FormCode code;

    public String name;

    public String description;

    public Form() {
    }
}
