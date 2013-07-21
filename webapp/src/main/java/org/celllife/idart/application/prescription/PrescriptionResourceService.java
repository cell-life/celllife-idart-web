package org.celllife.idart.application.prescription;

import org.celllife.idart.domain.prescription.Prescription;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 12h29
 */
public interface PrescriptionResourceService {

    Prescription save(Prescription prescription);

    Prescription findByIdentifier(String identifier);

    Iterable<Prescription> findAll();
}
