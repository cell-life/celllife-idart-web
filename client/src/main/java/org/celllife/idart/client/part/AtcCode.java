package org.celllife.idart.client.part;

import java.io.Serializable;

/**
 * Contains ATC codes and drug names for use in building up a drug database.
 */
public class AtcCode implements Serializable {

	private static final long serialVersionUID = 8134055235674905066L;

	String drugName;
	String atcCode;

	public AtcCode() {
		
	}

	public AtcCode(String name, String code) {
		this.drugName = name;
		this.atcCode = code;
	}

	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getAtcCode() {
		return atcCode;
	}
	public void setAtcCode(String atcCode) {
		this.atcCode = atcCode;
	}

	
}
