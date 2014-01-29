package org.celllife.idart.application.part

import org.celllife.idart.framework.aspectj.LogLevel
import org.celllife.idart.framework.aspectj.Loggable

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildGetDrugListRequest
import static org.springframework.util.Assert.notNull

/**
 * Provider used to retrieve a drug list (with ATC codes) from a service provider. (E.g. PREHMIS)
 */
interface DrugProvider {

    def findAll(String clinicIdValue)
	
}
