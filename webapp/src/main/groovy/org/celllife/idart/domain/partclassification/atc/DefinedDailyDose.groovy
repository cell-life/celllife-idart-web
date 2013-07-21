package org.celllife.idart.domain.partclassification.atc

import com.fasterxml.jackson.annotation.JsonIgnore
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.common.Quantity
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h23
 */
class DefinedDailyDose implements Persistable {

    @JsonIgnore Long pk

    Quantity quantity

    RouteOfAdministration route

}
