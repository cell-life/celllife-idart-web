package org.celllife.idart.domain.indication;

import org.celllife.idart.domain.common.Codeable;
import org.celllife.idart.domain.common.Describable;
import org.celllife.idart.domain.common.Nameable;
import org.celllife.idart.domain.common.Persistable;

import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 20h54
 */
@Entity
public final class Indication implements Persistable, Codeable, Nameable, Describable {

    public Indication() {
    }
}
