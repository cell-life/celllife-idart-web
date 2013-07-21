package org.celllife.idart.application.practitioner;

import org.celllife.idart.domain.practitioner.Practitioner;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 00h48
 */
public interface PractitionerApplicationService {

    List<Practitioner> findByClinicIdentifier(String applicationId, String clinicIdentifierValue);
}
