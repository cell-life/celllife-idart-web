package org.celllife.idart.application.part.dto

import org.celllife.idart.common.FormCode
import org.celllife.idart.common.Label
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.part.PartClassificationApplication

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h47
 */
abstract class PartDto implements Serializable {

    /**
     * Identified by
     */
    Set<Identifier> identifiers = [] as Set

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
}
