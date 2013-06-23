package org.celllife.idart.application.code

import org.celllife.idart.domain.counter.CounterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 21h42
 */
@Service class DoctorCodeApplicationServiceImpl extends DoctorCodeApplicationService {

  @Autowired def counterService: CounterService = null

  def nextDoctorCode(): String = "%08d".format(counterService.getNextValue("DoctorCode"))

}
