package org.celllife.idart.domain.part

import org.celllife.idart.common.PartClassificationCode
import org.celllife.idart.common.PartClassificationType

import static org.celllife.idart.common.PartClassificationCode.partClassificationCode

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
class PartClassificationApplications implements Serializable {

    static partClassificationApplications(String value, PartClassificationType type) {
        [new PartClassificationApplication(classification: partClassificationCode(value, type))] as Set
    }

    static getClassificationCode(Set<PartClassificationApplication> partClassificationApplications,
                                 PartClassificationType partClassificationType) {

        for (partClassificationApplication in partClassificationApplications) {

            if (partClassificationApplication.classification.type.equals(partClassificationType)) {
                return partClassificationApplication.classification.value
            }
        }

        return null
    }
}
