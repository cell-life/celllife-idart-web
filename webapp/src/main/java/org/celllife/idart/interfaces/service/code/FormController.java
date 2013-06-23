package org.celllife.idart.interfaces.service.code;

import org.celllife.idart.domain.form.Form;
import org.celllife.idart.domain.form.FormService;
import org.celllife.idart.integration.hl7.Code;
import org.celllife.idart.integration.hl7.CodeFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.celllife.idart.integration.hl7.Hl7CodeFileReader.readFile;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h03
 */
@Controller
@RequestMapping("/service/codes/forms")
public final class FormController {

    @Autowired
    private FormService formService;

    @RequestMapping(method = RequestMethod.POST)
    public void uploadHl7(@RequestParam("structure") String structure,
                          @RequestBody byte[] fileContent,
                          HttpServletResponse response) {

        switch (structure) {
            case "hl7":
                formService.save(getFormsFromHl7(fileContent));
                break;
        }

        response.setStatus(HttpServletResponse.SC_OK);
    }

    private List<Form> getFormsFromHl7(byte[] fileContent) {

        List<Form> results = new ArrayList<>();

        CodeFile codeFile = readFile("HL7v3 MaterialForm", new ByteArrayInputStream(fileContent));

        if (codeFile == null) {
            return results;
        }

        for (Code code : codeFile.getCodes()) {
            Form form = new Form();
            form.setName(code.getName());
            form.setDescription(code.getDescription());
            form.addCode(codeFile.getSystem(), code.getCode());
            results.add(form);
        }

        return results;
    }
}
