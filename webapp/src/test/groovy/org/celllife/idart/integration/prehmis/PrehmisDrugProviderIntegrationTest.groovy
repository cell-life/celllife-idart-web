package org.celllife.idart.integration.prehmis

import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-13
 * Time: 20h13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
class PrehmisDrugProviderIntegrationTest {

    static final SOAP_NAMESPACE = 'http://schemas.xmlsoap.org/soap/envelope/'

    static final PREHMIS_NAMESPACE = 'http://prehmis-qa.capetown.gov.za/'

    @Autowired PrehmisDrugProvider prehmisDrugProvider

    @Test
    void testFindByIdentifier() throws Exception {

        def getDrugListResponse = prehmisDrugProvider.findAll("WES")

        def envelope = getDrugListResponse.data
        envelope.declareNamespace(soap: SOAP_NAMESPACE, prehmis: PREHMIS_NAMESPACE)

        envelope.'soap:Body'.'prehmis:getDrugListResponse'.result.item.each {
            println "id ${it.id}"
            println "drug_type ${it.drug_type}"
            println "drug_name ${it.drug_name}"
            println "drug_group ${it.drug_group}"
            println "drug_order ${it.drug_order}"
            println "sequence ${it.code}"
            println "atc_code ${it.atc_code}"
            println "is_deleted ${it.is_deleted}"
            println ""
       }
   }
}