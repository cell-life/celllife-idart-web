package org.celllife.idart.domain.part

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.celllife.idart.domain.common.Identifiable
import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

import static org.celllife.idart.framework.aspectj.InjectCoded.inject

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
@ToString
@EqualsAndHashCode
@Mixin(Identifiable)
class Part implements Persistable {

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

    void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = inject(unitOfMeasure)
    }

    void setForm(Form form) {
        this.form = inject(form)
    }

    def mergeClassifications(Part that) {

        if (!this.class.isAssignableFrom(that.class)) {
            throw new RuntimeException("Incompatible Part Types: this ${this.class} that ${that.class}")
        }

        that.classifications.each { classification -> this.classifications << classification }
    }
}
