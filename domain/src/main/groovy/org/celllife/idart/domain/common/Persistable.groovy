package org.celllife.idart.domain.common

import com.fasterxml.jackson.annotation.JsonIgnore

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 19h37
 */
interface Persistable<T> {

    @JsonIgnore T getPk()

    void setPk(T pk)

}
