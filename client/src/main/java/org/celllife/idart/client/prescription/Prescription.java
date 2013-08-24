package org.celllife.idart.client.prescription;

import org.celllife.idart.client.common.Id;
import org.celllife.idart.client.partyrole.PartyRole;
import org.celllife.idart.client.visit.Encounter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 23h51
 */
public final class Prescription implements Serializable {

    public Set<Id> ids = new HashSet<Id>();

    public PartyRole prescriber;

    public PartyRole patient;

    public Date dateWritten;

    public Encounter encounter;

    public Set<PrescribedMedication> prescribedMedications = new HashSet<PrescribedMedication>();

}
