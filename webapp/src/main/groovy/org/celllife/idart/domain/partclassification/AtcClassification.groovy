package org.celllife.idart.domain.partclassification

import org.celllife.idart.domain.partclassification.atc.DefinedDailyDose

/**
 * Anatomical Therapeutic Chemical Classification
 * <p/>
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h23
 */
class AtcClassification extends PartClassification {

    Set<DefinedDailyDose> definedDailyDoses = []

}
