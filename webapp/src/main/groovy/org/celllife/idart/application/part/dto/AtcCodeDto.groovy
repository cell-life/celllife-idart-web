package org.celllife.idart.application.part.dto

import java.io.Serializable;

/**
 * This Dto is used to map the ATC code information used by iDART when creating drugs.
 */
class AtcCodeDto implements Serializable {
	
	String drugName;
	String atcCode;
	
	public AtcCodeDto() {
		
	}

	public AtcCodeDto(String name, String code) {
		this.drugName = name
		this.atcCode = code
	}

	@Override
	public String toString() {
		return "AtcCodeDto [drugName=" + drugName + ", atcCode=" + atcCode
				+ "]";
	}
}
