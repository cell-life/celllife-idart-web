package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.identifiable.Identifier

/**
 */
interface PatientApplicationService {

    PatientId save(PatientDto patientDto)

    PatientDto findByPatientId(PatientId patientId)

    PatientDto findByIdentifier(Identifier identifier)

    Set<PatientDto> findByIdentifierAndFacility(String identifier, FacilityId facilityId)

}