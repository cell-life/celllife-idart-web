package org.celllife.idart.domain.person

import org.celllife.idart.common.PersonId

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 18h09
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PersonSequence {

    PersonId nextValue()

}
