package org.celllife.idart.domain.identifiable

import groovy.transform.EqualsAndHashCode
import org.celllife.idart.common.AuthorityId

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 17h36
 */
@EqualsAndHashCode
class Identifier {

    AuthorityId authority

    String value

}
