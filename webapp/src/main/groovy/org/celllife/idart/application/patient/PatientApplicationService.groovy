package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.PatientId
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.SystemId

/**
 */
interface PatientApplicationService {

    PatientId save(PatientDto patientDto)

    PatientDto findByPatientId(PatientId patientId)

    PatientDto findByIdentifier(Identifier identifier)

    PatientId findByIdentifiers(Set<Identifier> identifiers)

    Set<PatientDto> findByIdentifierAndFacility(String identifier, FacilityId facilityId)

    Set<PatientDto> findByIdentifierAndSystem(String identifier, SystemId systemId)

    Set<PatientDto> findByIdentifierAndPerson(String identifier, PersonId personId)
}