package org.celllife.idart.domain.clinicdispensation

import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.dispensation.Dispensation

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface ClinicDispensationService {

    boolean exists(Clinic clinic, Dispensation dispensation, Date dateActive)

    void save(Clinic clinic, Dispensation dispensation)

    void save(Clinic clinic, Iterable<Dispensation> dispensations)

    void save(Dispensation dispensation, Iterable<Clinic> clinics)

    void deleteByClinic(Clinic clinic)

    void deleteByDispensation(Dispensation dispensation)

    void delete(Clinic clinic, Dispensation dispensation)

    Iterable<Dispensation> findDispensationsByClinic(Clinic clinic)

    Iterable<Dispensation> findDispensationsByClinicIdentifier(String clinicIdentifier)

    Iterable<Dispensation> findDispensationsByClinicIdentifierAndDispensationIdentifier(String clinicIdentifier, String dispensationIdentifier)

    Dispensation findOneDispensationByClinicIdentifierAndDispensationIdentifier(String clinicIdentifier, String dispensationIdentifier)

    Iterable<Clinic> findClinicsByDispensation(Dispensation dispensation)
}
