package org.celllife.idart.domain.dosageinstruction;

import org.celllife.idart.domain.common.Codeable;
import org.celllife.idart.domain.common.Describable;
import org.celllife.idart.domain.common.Nameable;
import org.celllife.idart.domain.common.Persistable;
import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Entity
public final class DosageInstruction implements Persistable, Codeable, Nameable, Describable {

    public DosageInstruction() {
    }

}
