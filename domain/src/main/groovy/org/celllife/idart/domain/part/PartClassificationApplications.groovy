package org.celllife.idart.domain.part

import org.celllife.idart.common.PartClassificationType

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 10h23
 */
class PartClassificationApplications {


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
