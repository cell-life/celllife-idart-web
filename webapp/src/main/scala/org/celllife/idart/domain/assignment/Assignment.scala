package org.celllife.idart.domain.assignment

import org.celllife.idart.domain.common.PersistableS
import org.celllife.idart.domain.doctor.Doctor
import org.celllife.idart.domain.clinic.Clinic
import scala.beans.BeanProperty

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 20h11
 */
class Assignment extends PersistableS {

  @BeanProperty var doctor: Doctor = null

  @BeanProperty var clinic: Clinic = null

  def this(doctor:Doctor, clinic:Clinic) {
    this()
  }
}
