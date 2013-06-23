package org.celllife.idart.application.patient;

import org.celllife.idart.application.ClinicNotFoundException;
import org.celllife.idart.domain.clinic.Clinic;
import org.celllife.idart.domain.clinic.ClinicRepository;
import org.celllife.idart.domain.patient.PatientRepository;
import org.celllife.idart.framework.aspectj.LogLevel;
import org.celllife.idart.framework.aspectj.Loggable;
import org.celllife.idart.interfaces.service.patient.FindPatientsByIdentifierRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Service("patientApplicationService")
public final class PatientApplicationServiceImpl implements PatientApplicationService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrehmisPatientApplicationService prehmisPatientApplicationService;

    @Override
    @Loggable(value = LogLevel.INFO, exception = LogLevel.ERROR)
    public FindPatientsByIdentifierResponse findByIdentifier(FindPatientsByIdentifierRequest request) {

        String clinicIdentifier = request.getClinicIdentifier();

        Clinic clinic = clinicRepository.findOneByIdentifier("http://www.cell-life.org/idart/facility", clinicIdentifier);

        if (clinic == null) {
            throw new ClinicNotFoundException("Clinic not found for identifier value: " + clinicIdentifier);
        }

        String patientIdentifier = request.getPatientIdentifier();

        lookupAndSyncWithExternalProviders(patientIdentifier, clinic);

        FindPatientsByIdentifierResponse response = new FindPatientsByIdentifierResponse();
        response.setPatients(patientRepository.findByIdentifier(patientIdentifier));
        return response;
    }

    private void lookupAndSyncWithExternalProviders(String patientIdentifierValue, Clinic clinic) {

        for (String identifierSystem : clinic.getIdentifierSystems()) {
            String clinicIdentifierValue = clinic.getIdentifierValue(identifierSystem);
            switch (identifierSystem) {
                case "http://prehmis.capetown.gov.za":
                    prehmisPatientApplicationService.lookupAndSynchronise(patientIdentifierValue, clinicIdentifierValue);
                    break;
                default:
                    break;
            }
        }
    }
}
