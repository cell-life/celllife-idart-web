package org.celllife.idart.domain.dispensation

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.PatientId
import org.celllife.idart.common.PractitionerId

/**
 * Provision of a supply of a medication with the intention that it is subsequently consumed by a patient
 * (usually in response to a prescription).
 */
@ToString
@EqualsAndHashCode
class Dispensation implements Serializable {

    /**
     * Identified by
     */
    DispensationId id

    /**
     * Dispensed to
     *
     * Although the patient could be inferred from the prescription, this is put here explicitly because the dispense
     * action may take place without a prescription.
     */
    PatientId patient

    /**
     * Dispensed by
     */
    PractitionerId dispenser

    /**
     * Dispensed at
     */
    FacilityId facility

    /**
     * Handed over at
     */
    Date handedOver

    /**
     * Contains
     */
    Set<DispensedMedication> dispensedMedications = []

    def merge(Dispensation that) {

        if (that == null) {
            return
        }

        this.patient = that.patient
        this.dispenser = that.dispenser
        this.facility = that.facility
        this.handedOver = that.handedOver
        this.dispensedMedications?.addAll(that.dispensedMedications)
    }
}
