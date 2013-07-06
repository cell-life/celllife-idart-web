package org.celllife.idart.domain.common

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 19h37
 */
class PersistableM {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long pk

}
