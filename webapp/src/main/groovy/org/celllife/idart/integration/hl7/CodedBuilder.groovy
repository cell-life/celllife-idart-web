package org.celllife.idart.integration.hl7

import org.celllife.idart.domain.common.Codeable

interface CodedBuilder<C extends Codeable> {

    C newCodedConcept(String system, String code, String locale, String name, String description)

}