package org.celllife.idart.domain.atc

import org.celllife.idart.common.Quantity
import org.celllife.idart.common.RouteOfAdministrationCode

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h23
 */
class DefinedDailyDose implements Serializable {

    Long pk

    Quantity quantity

    RouteOfAdministrationCode route

}
