package org.celllife.idart.interfaces.service.form

import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormService
import org.celllife.idart.integration.hl7.CodeFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_OK
import static org.celllife.idart.integration.hl7.Hl7CodeFileReader.readFile

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h03
 */
@Controller class FormServiceController {

    @Autowired FormService formService

    @RequestMapping(value = "/forms/upload", method = RequestMethod.POST)
    void upload(@RequestParam("structure") String structure,
                   @RequestBody byte[] fileContent,
                   HttpServletResponse response) {

        switch (structure) {
            case "hl7":
                formService.save(getFormsFromHl7(fileContent))
                break
        }

        response.status = SC_OK
    }

    static List<Form> getFormsFromHl7(byte[] fileContent) {

        CodeFile codeFile = readFile("HL7v3 MaterialForm", new ByteArrayInputStream(fileContent))

        if (codeFile == null) {
            return []
        }

        codeFile.codes.collect { code ->
            Form form = new Form(name: code.name, description: code.description)
            form.addCode(codeFile.system, code.code)
            form
        }
    }
}
