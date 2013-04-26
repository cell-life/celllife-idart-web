package org.celllife.idart.application.patient;

import org.celllife.idart.domain.clinic.Clinic;
import org.celllife.idart.domain.clinic.ClinicIdentifierType;
import org.celllife.idart.domain.clinic.ClinicRepository;
import org.celllife.idart.domain.patient.Patient;
import org.celllife.idart.domain.patient.PatientRepository;
import org.celllife.idart.domain.patient.PatientService;
import org.celllife.idart.framework.logging.LogLevel;
import org.celllife.idart.framework.logging.Loggable;
import org.celllife.idart.integration.prehmis.PrehmisPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    private PatientService patientService;

    @Autowired
    private PrehmisPatientService prehmisPatientService;

    @Override
    @Loggable(value = LogLevel.INFO, exception = LogLevel.ERROR)
    public List<Patient> findByIdentifier(String applicationIdentifier,
                                          String idartClinicIdentifierValue,
                                          String patientIdentifierValue) {

        Clinic clinic = clinicRepository.findOneByIdentifier(idartClinicIdentifierValue, ClinicIdentifierType.IDART);

        if (clinic == null) {
            throw new ClinicNotFoundException("Clinic not found for identifier value: " + idartClinicIdentifierValue);
        }

        if (!clinic.getApplicationIdentifier().equals(applicationIdentifier)) {
            throw new ClinicNotFoundException("Clinic not found for identifier value: " + idartClinicIdentifierValue);
        }

        for (ClinicIdentifierType identifierType : clinic.getIdentifierTypes()) {

            switch (identifierType) {
                case PREHMIS:
                    String clinicIdentifierValue = clinic.getIdentifierValue(identifierType);
                    Set<Patient> prehmisPatients =
                            prehmisPatientService.findByIdentifier(clinicIdentifierValue, patientIdentifierValue);

                    patientService.save(prehmisPatients);
            }
        }

        return patientRepository.findByIdentifier(patientIdentifierValue);
    }

}
