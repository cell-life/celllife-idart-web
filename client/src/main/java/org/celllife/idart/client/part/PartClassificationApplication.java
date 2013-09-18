package org.celllife.idart.client.part;

import org.celllife.idart.common.PartClassificationCode;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 14h50
 */
public class PartClassificationApplication {

    private PartClassificationCode classification;

    public PartClassificationApplication() {
    }

    public PartClassificationApplication(PartClassificationCode classification) {
        this.classification = classification;
    }

    public PartClassificationCode getClassification() {
        return classification;
    }

    public void setClassification(PartClassificationCode classification) {
        this.classification = classification;
    }
}
