package org.celllife.idart.application.patient;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h38
 */
public interface PrehmisPatientApplicationService {

    void lookupAndSynchronise(String patientIdentifierValue, String clinicIdentifierValue);

}
