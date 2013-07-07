package org.celllife.idart.domain.partclassification

import org.celllife.idart.domain.common.Codeable
import org.celllife.idart.domain.common.Describable
import org.celllife.idart.domain.common.Persistable
import org.celllife.idart.domain.concept.Code
import org.celllife.idart.domain.concept.LocalisedText

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h22
 */
@Mixin([Codeable, Describable])
abstract class PartClassification implements Persistable {

    Long pk

    Set<Code> codes = []

    Set<LocalisedText> descriptions = []

    PartClassification parent

}
