package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 18h09
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PatientSequence {

    PatientId nextValue()

}
