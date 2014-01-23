package org.celllife.idart.integration.prehmis

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.application.practitioner.PractitionerProvider
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.framework.aspectj.LogLevel
import org.celllife.idart.framework.aspectj.Loggable
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import static org.celllife.idart.integration.prehmis.builder.PractitionerBuilder.buildPractitioners
import static org.celllife.idart.integration.prehmis.builder.PrehmisRequestBuilder.buildGetPractitionerListRequest
import static org.springframework.util.Assert.notNull

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h13
 */
@Service class PrehmisPractitionerProvider implements PractitionerProvider, InitializingBean {

	@Value('${prehmis.endpoint.baseUrl}')
	String prehmisEndpointBaseUrl
	
    @Value('${prehmis.endpoint.url}')
	String prehmisEndpointUrl

    @Value('${prehmis.username}')
	String prehmisUsername

    @Value('${prehmis.password}')
	String prehmisPassword

    @Value('${prehmis.applicationKey}')
	String prehmisApplicationKey

    RESTClient prehmisRestClient

    @Override
	@Loggable(LogLevel.INFO)
    Set<PractitionerDto> findAll(String clinicIdValue) {

        String getPractitionerListRequest = buildGetPractitionerListRequest(
                username: prehmisUsername,
                password: prehmisPassword,
                facilityCode: clinicIdValue,
                applicationKey: prehmisApplicationKey
        )

        def getPractionerListResponse = prehmisRestClient.post(
                body: getPractitionerListRequest,
                contentType: ContentType.XML,
                requestContentType: ContentType.XML,
                headers: [
                        SOAPAction: prehmisEndpointBaseUrl + "/getPractitionerList"
                ]
        )

        return buildPractitioners(getPractionerListResponse)
    }

    @Override
    void afterPropertiesSet() throws Exception {

        notNull(prehmisEndpointUrl)

        notNull(prehmisUsername)

        notNull(prehmisPassword)

        notNull(prehmisApplicationKey)

        prehmisRestClient = new RESTClient(prehmisEndpointUrl)

    }
}
