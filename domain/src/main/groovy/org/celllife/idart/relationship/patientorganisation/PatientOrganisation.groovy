package org.celllife.idart.relationship.patientorganisation

import groovy.transform.ToString

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PatientId
import org.celllife.idart.common.Period

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 14h59
 */
@ToString
class PatientOrganisation implements Serializable {

    enum Relationship {

        REGISTERED_WITH

    }

    Long pk

    PatientId patient

    OrganisationId organisation

    Relationship relationship

    Period valid


}
