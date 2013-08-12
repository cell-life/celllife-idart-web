package org.celllife.idart.domain.part

import org.celllife.idart.common.FormCode
import org.celllife.idart.common.PartClassificationType
import org.celllife.idart.common.PartIdentifier
import org.celllife.idart.common.UnitOfMeasureCode

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
abstract class Part {

    /**
     * Identified by
     */
    PartIdentifier identifier

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

        return this.identifier == that.identifier
    }

    def getClassificationCode(PartClassificationType type) {
        for (classification in classifications) {
            if (classification.type == type) {
                return classification.code
            }
        }
        null
    }

    def addClassification(PartClassificationType type, String code) {
        this.classifications.add(new PartClassificationApplication(type: type, code: code))
    }
}
