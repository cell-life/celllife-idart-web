package org.celllife.idart.domain.prescription
/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 21h12
 */
public interface PrescriptionRepository {

    Prescription findOneByIdentifier(String identifierSystem, String identifierValue);

}
