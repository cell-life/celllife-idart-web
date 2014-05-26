package org.celllife.idart.interfaces.web

import groovy.text.SimpleTemplateEngine

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Builds the iDARTweb POSTS used to create entities via the service REST API
 */
class IDartwebPostBuilder {
	
	static final Logger LOGGER = LoggerFactory.getLogger(IDartwebPostBuilder)

    static engine = new SimpleTemplateEngine()

    static buildUser(args) {
        build("/templates/idartweb/user.json", args)
    }

    static buildOrganisation(args) {
        build("/templates/idartweb/organisation.json", args)
    }

    static buildFacility(args) {
        build("/templates/idartweb/facility.json", args)
    }

    static buildFacilityOrganisation(args) {
        build("/templates/idartweb/facilityOrganisation.json", args)
    }

    static buildSystem(args) {
        build("/templates/idartweb/system.json", args)
    }

    static buildSystemFacility(args) {
        build("/templates/idartweb/systemFacility.json", args)
    }

    static buildProduct(args) {
        build("/templates/idartweb/product.json", args)
    }

    static build(String templateFilename, args) {

        def inputStream = IDartwebPostBuilder.class.getResourceAsStream(templateFilename)
        def inputStreamReader = new InputStreamReader(inputStream)
        def template = engine.createTemplate(inputStreamReader).make(args)
		
        String json = template.toString() 
        LOGGER.debug("iDARTweb post. template: '"+templateFilename+"' json: "+json)
        return json
    }
}
