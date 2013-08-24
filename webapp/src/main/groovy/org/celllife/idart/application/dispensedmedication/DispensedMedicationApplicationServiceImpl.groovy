package org.celllife.idart.application.dispensedmedication

import org.celllife.idart.domain.dispensedmedication.DispensedMedication
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationValidationException
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationNotFoundException
import org.celllife.idart.common.DispensedMedicationId
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DispensedMedicationApplicationServiceImpl implements DispensedMedicationApplicationService {

    @Autowired DispensedMedicationService dispensedMedicationService

    DispensedMedication save(DispensedMedication dispensedMedication) throws DispensedMedicationValidationException {
        dispensedMedicationService.save(dispensedMedication)
    }

    DispensedMedication findByDispensedMedicationId(DispensedMedicationId dispensedMedicationId) throws DispensedMedicationNotFoundException{
        dispensedMedicationService.findByDispensedMedicationId(dispensedMedicationId)
    }

}
