package org.celllife.idart.integration.prehmis
import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.celllife.idart.application.doctor.DoctorProvider
import org.celllife.idart.domain.doctor.Doctor
import org.celllife.idart.integration.prehmis.builder.GetPractitionerListRequestBuilder
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import static org.celllife.idart.integration.prehmis.builder.DoctorBuilder.buildDoctors
import static org.springframework.util.Assert.notNull
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h13
 */
@Service("prehmisDoctorProvider")
class PrehmisDoctorProvider implements DoctorProvider, InitializingBean {

    @Value('${prehmis.endpoint.url}')
    String prehmisEndpointUrl;

    @Value('${prehmis.username}')
    String prehmisUsername;

    @Value('${prehmis.password}')
    String prehmisPassword;

    @Value('${prehmis.applicationKey}')
    String prehmisApplicationKey;

    RESTClient prehmisRestClient

    @Override
    Set<Doctor> findAll(String clinicIdentifierValue) {

        String getPractitionerListRequest = new GetPractitionerListRequestBuilder()
                .setUsername(prehmisUsername)
                .setPassword(prehmisPassword)
                .setApplicationKey(prehmisApplicationKey)
                .setFacilityCode(clinicIdentifierValue)
                .build()

        def getPractionerListResponse = prehmisRestClient.post(
                body: getPractitionerListRequest,
                contentType: ContentType.XML,
                requestContentType: ContentType.XML,
                headers: [
                        SOAPAction: "http://prehmis-qa.capetown.gov.za/getPractitionerList"
                ]
        )

        return buildDoctors(getPractionerListResponse)
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
