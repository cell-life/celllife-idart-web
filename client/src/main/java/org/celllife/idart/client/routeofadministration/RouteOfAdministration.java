package org.celllife.idart.client.routeofadministration;

import org.celllife.idart.common.RouteOfAdministrationCode;

import java.io.Serializable;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h57
 */
public final class RouteOfAdministration implements Serializable {

    public RouteOfAdministrationCode code;

    public String name;

    public String description;

    public RouteOfAdministration() {
    }
}
