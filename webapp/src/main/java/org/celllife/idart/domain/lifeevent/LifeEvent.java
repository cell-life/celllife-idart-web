package org.celllife.idart.domain.lifeevent;

import org.celllife.idart.domain.common.Codeable;
import org.celllife.idart.domain.common.Describable;
import org.celllife.idart.domain.common.Nameable;
import org.celllife.idart.domain.common.Persistable;

import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Entity
public final class LifeEvent implements Persistable, Codeable, Nameable, Describable {

    public LifeEvent() {
    }

}
