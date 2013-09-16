package org.celllife.idart.client.prescription;

import org.celllife.idart.common.Identifier;

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

    public Set<Identifier> identifiers = new HashSet<Identifier>();

    public Set<Identifier> prescriber;

    public Set<Identifier> patient;

    public Date dateWritten;

    public Set<Identifier> encounter;

    public Set<PrescribedMedication> prescribedMedications = new HashSet<PrescribedMedication>();

}
