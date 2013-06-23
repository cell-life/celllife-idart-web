package org.celllife.idart.domain.product;

import org.celllife.idart.domain.common.Codeable;
import org.celllife.idart.udm.part.FinishedGood;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h14
 */
@Entity
public final class Good extends Product implements Codeable {

    /**
     * Offered using
     */
    @NotNull
    @ManyToOne(optional = false)
    private FinishedGood finishedGood;

    public Good() {
    }

    public Good(String name, FinishedGood finishedGood) {
        super(name);
        this.finishedGood = finishedGood;
    }

    public FinishedGood getFinishedGood() {
        return finishedGood;
    }

    public void setFinishedGood(FinishedGood finishedGood) {
        this.finishedGood = finishedGood;
    }
}
