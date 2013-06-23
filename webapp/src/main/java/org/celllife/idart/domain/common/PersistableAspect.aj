package org.celllife.idart.domain.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect PersistableAspect {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long Persistable.pk;

    public Long Persistable.getPk() {
        return this.pk;
    }

    public void Persistable.setPk(Long pk) {
        this.pk = pk;
    }
}
