package org.celllife.idart.domain.codedconcept;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.celllife.idart.domain.form.Form;
import org.celllife.idart.domain.form.FormRespository;
import org.celllife.idart.test.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 19h01
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FormRespositoryIntegrationTest {

    @Autowired
    private FormRespository formRespository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldLoadAllForms() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/form/all.json");

        List<Form> forms = objectMapper.readValue(inputStream, new TypeReference<List<Form>>() {
        });

        formRespository.save(forms);

    }
}
