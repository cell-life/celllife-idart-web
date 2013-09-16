package org.celllife.idart.domain.part

import org.celllife.idart.common.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
abstract class Part implements Serializable {

    /**
     * Identified by
     */
    PartId id

    /**
     * Labelled as
     */
    Label label

    UnitOfMeasureCode unitOfMeasure

    FormCode form

    /**
     * Classified into
     */
    Set<PartClassificationApplication> classifications = []

    def merge(Part that) {
        if (that == null) {
            return
        }

        this.unitOfMeasure = that.unitOfMeasure
        this.form = that.form
        that.classifications?.each { classification -> this.classifications << classification }
    }

    def matches(Part that) {

        if (that == null) {
            return false
        }

        return this.id == that.id
    }

    def getClassificationCode(PartClassificationType type) {
        for (classification in classifications) {
            if (classification.classification.type == type) {
                return classification.classification
            }
        }
        null
    }

    def addClassification(PartClassificationType type, String code) {
        this.classifications.add(new PartClassificationApplication(classification: new PartClassificationCode(type: type, value: code)))
    }
}
