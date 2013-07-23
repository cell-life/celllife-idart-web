package org.celllife.idart.domain.part

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
@ToString
@EqualsAndHashCode(excludes = "pk")
@Mixin(Identifiable)
abstract class Part implements Persistable<Long> {

    /**
     * Persistence Key
     */
    Long pk

    /**
     * Named as
     */
    Set<Identifier> identifiers = []

    UnitOfMeasure unitOfMeasure

    Form form

    /**
     * Classified into
     */
    Set<PartClassification> classifications = []

    def merge(Part that) {
        if (that == null) {
            return
        }

        this.mergeIdentifiers(that)
        this.unitOfMeasure = that.unitOfMeasure
        this.form = that.form
        that.classifications?.each { classification -> this.classifications << classification }
    }

    def matches(Part that) {

        if (that == null) {
            return false
        }

        for (identifierSystem in this.getIdentifierSystems()) {
            if (this.getIdentifierValue(identifierSystem) == that.getIdentifierValue(identifierSystem)) {
                return true
            }
        }

        return false
    }
}
