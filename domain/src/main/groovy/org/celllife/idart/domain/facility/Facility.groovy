package org.celllife.idart.domain.facility

import org.celllife.idart.domain.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h03
 */
@Mixin([Identifiable, Nameable, Describable])
abstract class Facility implements Persistable<String> {

    /**
     * Persistence Key
     */
    String pk

    /**
     * Identified by
     */
    Set<Identifier> identifiers = []

    Set<LocalisedText> names = []

    Set<LocalisedText> descriptions = []

    Quantity area

    def merge(Facility that) {

        if (that == null) {
            return
        }

        that.identifiers?.each { identifier -> this.identifiers << identifier }
        that.names?.each { name -> this.names << name }
        that.descriptions?.each { description -> this.descriptions << description }

        this.area = that.area
    }

}
