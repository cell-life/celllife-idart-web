package org.celllife.idart.application.dispensedmedication

import org.celllife.idart.domain.dispensedmedication.DispensedMedication
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DispensedMedicationApplicationServiceImpl implements DispensedMedicationApplicationService, DispensedMedicationResourceService {

    @Autowired DispensedMedicationService dispensedMedicationService

    DispensedMedication save(DispensedMedication dispensedMedication) {
        dispensedMedicationService.save(dispensedMedication)
    }

    DispensedMedication findByIdentifier(String identifier) {
        dispensedMedicationService.findByIdentifier(identifier)
    }

    Iterable<DispensedMedication> findAll() {
        dispensedMedicationService.findAll()
    }

}