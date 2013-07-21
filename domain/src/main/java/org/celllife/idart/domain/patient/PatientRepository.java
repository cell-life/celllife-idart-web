package org.celllife.idart.domain.patient;


/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 09h53
 */
public interface PatientRepository {

    Patient findOneByIdentifier(String identifierSystem,
                                String identifierValue);

}
