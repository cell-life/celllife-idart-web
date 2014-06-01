package org.celllife.idart.interfaces.web

import groovyx.net.http.HttpResponseDecorator

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.common.Systems
import org.celllife.idart.framework.rest.RESTClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

/**
 * iDARTweb admin controller
 */
@Controller
class AdminController {

    static final Logger LOGGER = LoggerFactory.getLogger(AdminController)

    @Value('${external.base.url}')
    def String externalBaseUrl

    @Inject
    RESTClient client;

    @RequestMapping(value="/ui/admin", method = RequestMethod.GET)
    def admin(Model model) {
        return new ModelAndView("ui/admin", model);
    }
    
    @RequestMapping(value="/ui/admin/eventerror", method = RequestMethod.GET)
    def eventErrors(Model model) {
        def eventErrors = client.get(externalBaseUrl+"/eventerrors")
        model.put("eventErrors", eventErrors)
        return new ModelAndView("ui/admin/eventerror", model);
    }

    @RequestMapping(value="/ui/admin/registration", method = RequestMethod.GET)
    def registration(Model model) {

        def facilities = client.get(externalBaseUrl+"/facilities")
        def facilityMap = [] as Set
        for (f in facilities) {
            for (id in f["identifiers"]) {
                def facilityName = f["name"]
                def systemId = id["system"]
                def idValue = id["value"]
                if (Systems.IDART_WEB.id.value.equals(systemId)) {
                    def facilityProperties = ["id": idValue, "name": facilityName]
                    facilityMap.add(facilityProperties)
                }
            }
        }
        model.put("facilities", facilityMap)

        def organisations = client.get(externalBaseUrl+"/organisations")
        def organisationMap = [] as Set
        for (o in organisations) {
            for (id in o["identifiers"]) {
                def orgName = o["name"]
                def systemId = id["system"]
                def idValue = id["value"]
                if (Systems.IDART_WEB.id.value.equals(systemId)) {
                    def orgProperties = ["id": idValue, "name": orgName]
                    organisationMap.add(orgProperties)
                }
            }
        }
        model.put("organisations", organisationMap)

        return new ModelAndView("ui/admin/registration", model);
    }

    @RequestMapping(value="/ui/admin/registration/user", method = RequestMethod.POST)
    def createUser(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String[]> params = request.getParameterMap();
            def user = IDartwebPostBuilder.buildUser([
                username: username,
                password: password
            ])
            def httpResponseDecorator = client.postJson(externalBaseUrl+"/users", user)
            def userId = getIdentifierFromLocation(httpResponseDecorator)
            if (!userId.empty) {
                model.put("regMessage", "User '"+username+"' saved successfully.");
            } else {
                model.put("errorMessage", "Error while saving User. ("+getErrorMessage(httpResponseDecorator)+")");
            }
        } catch (Throwable t) {
            LOGGER.error("Error while saving User '"+username+"'", t);
            model.put("errorMessage", "Error while saving User '"+username+"'. Please check logs for more details.");
        }
        registration(model)
    }

    @RequestMapping(value="/ui/admin/registration/facility", method = RequestMethod.POST)
    def createFacility(@RequestParam("name") String name, @RequestParam("description") String description,
            @RequestParam("prehmisId") String prehmisId, @RequestParam("organisation") String organisation,
            Model model, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        try {
            def facility = IDartwebPostBuilder.buildFacility([
                name: name,
                description: description,
                prehmisId: prehmisId
            ])
            def httpResponseDecorator = client.postJson(externalBaseUrl+"/facilities", facility)
            def facilityId = getIdentifierFromLocation(httpResponseDecorator)
            if (!facilityId.empty) {
                def facilityOrganisation = IDartwebPostBuilder.buildFacilityOrganisation([
                    facilityId: facilityId,
                    organisationId: organisation
                ])
                client.postJson(externalBaseUrl+"/facilityOrganisation", facilityOrganisation)
                model.put("regMessage", "Facility '"+name+"' and association with organsation '"+organisation+"' saved successfully.");
            } else {
                model.put("errorMessage", "Error while saving Facility. ("+getErrorMessage(httpResponseDecorator)+")");
            }
        } catch (Throwable t) {
            LOGGER.error("Error while saving Facility '"+name+"'", t);
            model.put("errorMessage", "Error while saving Facility '"+name+"'. Please check logs for more details.");
        }
        registration(model)
    }

    @ResponseBody
    @RequestMapping(value="/ui/admin/registration/organisation", method = RequestMethod.POST)
    def createOrganisation(@RequestParam("name") String name,
            Model model, Principal principal, HttpServletRequest request) {
        try {
            def org = IDartwebPostBuilder.buildOrganisation([
                name: name
            ])
            def httpResponseDecorator = client.postJson(externalBaseUrl+"/organisations", org)
            def orgId = getIdentifierFromLocation(httpResponseDecorator)
            if (!orgId.empty) {
                model.put("regMessage", "Organisation '"+name+"' saved successfully.");
            } else {
                model.put("errorMessage", "Error while saving Organisation. ("+getErrorMessage(httpResponseDecorator)+")");
            }
        } catch (Throwable t) {
            LOGGER.error("Error while saving Organisation '"+name+"'", t);
            model.put("errorMessage", "Error while saving Organisation '"+name+"'. Please check logs for more details.");
        }

        registration(model)
    }

    @ResponseBody
    @RequestMapping(value="/ui/admin/registration/system", method = RequestMethod.POST)
    def createSystem(@RequestParam("applicationKey") String applicationKey, @RequestParam("facility") String facility,
            Model model, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        try {
            def system = IDartwebPostBuilder.buildSystem([
                applicationKey: applicationKey
            ])
            def httpResponseDecorator = client.postJson(externalBaseUrl+"/systems", system)
            def systemId = getIdentifierFromLocation(httpResponseDecorator)
            if (!systemId.empty) {
                createProducts(systemId) // <--- the drugs get created here (see below)
                def systemFacility = IDartwebPostBuilder.buildSystemFacility([
                    facilityId: facility,
                    systemId: systemId
                ])
                client.postJson(externalBaseUrl+"/systemFacility", systemFacility)
                model.put("regMessage", "System '"+systemId+"' and association with facility '"+facility+"' saved successfully.");
            } else {
                model.put("errorMessage", "Error while saving System. ("+getErrorMessage(httpResponseDecorator)+")");
            }
        } catch (Throwable t) {
            LOGGER.error("Error while saving System", t);
            model.put("errorMessage", "Error while saving System. Please check logs for more details.");
        }

        registration(model)
    }

    private void createProducts(String systemId) {
        // these are the default iDART drugs which are pre-loaded for each user
        createProduct(systemId, "00000001", "[ABC] Abacavir 20mg/ml", "99999001")
        createProduct(systemId, "00000002", "[ABC] Abacavir 300mg", "99999002")
        createProduct(systemId, "00000003", "[TDF] Tenofovir 300mg", "99999003")
        createProduct(systemId, "00000004", "[DDI] Didanosine 25mg", "99999004")
        createProduct(systemId, "00000005", "[DDI] Didanosine 50mg", "99999005")
        createProduct(systemId, "00000006", "[EFV] Efavirenz 200mg", "99999006")
        createProduct(systemId, "00000007", "[EFV] Efavirenz 50mg", "99999007")
        createProduct(systemId, "00000008", "[EFV] Efavirenz 600mg", "99999008")
        createProduct(systemId, "00000009", "[3TC] Lamivudine 10mg/ml", "99999009")
        createProduct(systemId, "00000010", "[3TC] Lamivudine 150mg", "99999010")
        createProduct(systemId, "00000011", "[NVP] Nevirapine 200mg", "99999011")
        createProduct(systemId, "00000012", "[NVP] Nevirapine 50mg/5ml", "99999012")
        createProduct(systemId, "00000013", "[RTV] Ritonavir 80mg/ml", "99999013")
        createProduct(systemId, "00000014", "[D4T] Stavudine 15mg", "99999014")
        createProduct(systemId, "00000015", "[D4T] Stavudine 1mg/ml", "99999015")
        createProduct(systemId, "00000016", "[D4T] Stavudine 20mg", "99999016")
        createProduct(systemId, "00000017", "[D4T] Stavudine 30mg", "99999017")
        createProduct(systemId, "00000018", "[AZT] Zidovudine 100mg", "99999018")
        createProduct(systemId, "00000019", "[AZT] Zidovudine 10mg/ml", "99999019")
        createProduct(systemId, "00000020", "[AZT] Zidovudine 300mg", "99999020")
        createProduct(systemId, "00000021", "[LPV/RTV] Kaletra 133.3/33.3 mg", "99999021")
        createProduct(systemId, "00000022", "[LPV/RTV] Kaletra 80/20 mg/ml", "99999022")
        createProduct(systemId, "00000023", "[RTV] Ritonavir 100mg", "99999023")
        createProduct(systemId, "00000024", "[DDI] Didanosine 100mg", "99999024")
        createProduct(systemId, "00000025", "[3TC/AZT] Lamzid 150/300mg", "99999025")
        createProduct(systemId, "00000026", "[LPV/RTV] Aluvia 200/50mg", "99999026")
    }

    private String createProduct(String systemId, String productId, String name, String drugId) {
        def product = IDartwebPostBuilder.buildProduct([
            name: name,
            drugId: drugId,
            productId: productId,
            systemId: systemId
        ])
        def httpResponseDecorator = client.postJson(externalBaseUrl+"/products", product)
        getIdentifierFromLocation(httpResponseDecorator)
    }

    private String getIdentifierFromLocation(HttpResponseDecorator httpResponseDecorator) {
        if (httpResponseDecorator.isSuccess()) {
            def location = httpResponseDecorator.headers.getAt("Location").value
            def locationElements = location.split("/")
            def identifier = locationElements[locationElements.length-1]
            LOGGER.debug("created element "+location+" with identifer ="+identifier)
            return identifier;
        }
    }

    private String getErrorMessage(HttpResponseDecorator httpResponseDecorator) {
        return "" + httpResponseDecorator.status + " " + httpResponseDecorator.statusCode
    }
}