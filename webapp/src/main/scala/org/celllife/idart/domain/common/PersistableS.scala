package org.celllife.idart.domain.common

import javax.persistence.{Id, GeneratedValue, GenerationType}
import scala.annotation.meta.field

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-06
 * Time: 20h09
 */
trait PersistableS {

  @(Id @field)
  @(GeneratedValue @field)(strategy = GenerationType.TABLE)
  @BeanProperty
  var id:Long = -1L

}
