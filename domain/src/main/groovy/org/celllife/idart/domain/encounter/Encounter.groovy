package org.celllife.idart.domain.encounter

import org.celllife.idart.common.Duration
import org.celllife.idart.common.EncounterId
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.PatientId

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-22
 * Time: 01h03
 */
class Encounter implements Serializable {

    /**
     * Identified by
     */
    EncounterId id

    /**
     * Participants
     */
    Set<Participant> participants

    /**
     * Patient
     */
    PatientId patient

    /**
     * Location
     */
    FacilityId facility

    /**
     * Started at
     */
    Date startedAt

    /**
     * Duration
     */
    Duration duration

    def merge(Encounter that) {

        if (that == null) {
            return
        }

        if (that.participants != null) {
            this.participants.addAll(that.participants)
        }

        this.patient = that.patient
        this.facility = that.facility
        this.startedAt = that.startedAt
        this.duration = that.duration
    }
}
