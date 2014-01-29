package org.celllife.idart.integration.prehmis.builder

import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.Systems.PREHMIS

import org.celllife.idart.application.part.dto.AtcCodeDto
import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.common.Systems
import org.celllife.idart.integration.prehmis.PrehmisPractitionerType

/**
 * Converts the PREHMIS drug list into the AtcCodeDto objects
 */
class AtcCodeBuilder {

	static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

	static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

	static Set<AtcCodeDto> buildAtcCodes(getDrugListResponse) {

		def envelope = getDrugListResponse.data
		envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

		def drugs = envelope.'soap:Body'.'prehmis:getDrugListResponse'.result.item
				.collect { buildAtcCode(it) }

		def result = drugs.findAll { it != null }

		result
	}

	static AtcCodeDto buildAtcCode(prehmisDrug) {

		AtcCodeDto atcDrug = new AtcCodeDto()

		// FIXME: should be more fancy to match the rest of this system, but I think it's overkill at the moment

		String drugName = prehmisDrug.drug_name.text()
		if (drugName == null || !drugName.empty) {
			atcDrug.drugName = drugName
		}

		String atcCode = prehmisDrug.atc_code.text()
		if (atcCode != null && !atcCode.empty) {
			atcDrug.atcCode = atcCode
		}

		atcDrug
	}
}
