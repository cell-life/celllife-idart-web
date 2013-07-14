package org.celllife.idart.domain.partclassification

import org.celllife.idart.domain.common.Describable
import org.celllife.idart.domain.common.LocalisedText
import org.celllife.idart.domain.common.Persistable

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h22
 */
@Mixin([Describable])
abstract class PartClassification implements Persistable {

    Long pk

    Set<LocalisedText> descriptions = []

    PartClassification parent

}
