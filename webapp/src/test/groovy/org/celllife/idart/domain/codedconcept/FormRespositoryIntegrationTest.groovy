package org.celllife.idart.domain.codedconcept

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormRepository
import org.celllife.idart.test.TestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 19h01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
class FormRespositoryIntegrationTest {

    @Autowired FormRepository formRespository

    @Autowired ObjectMapper objectMapper

    @Test
    void shouldLoadAllForms() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/form/all.json")

        List<Form> forms = objectMapper.readValue(inputStream, new TypeReference<List<Form>>() {})

        formRespository.save(forms)

    }
}
