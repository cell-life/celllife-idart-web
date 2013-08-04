package org.celllife.idart.application.administrationmethod

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.integration.hl7.Code

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 07h47
 */
class ExternalAdministrationMethod {

    @Delegate
    AdministrationMethod administrationMethod

    Set<Code> codes



}
