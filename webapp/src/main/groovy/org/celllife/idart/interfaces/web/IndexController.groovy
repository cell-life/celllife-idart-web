package org.celllife.idart.interfaces.web

import javax.inject.Inject

import org.celllife.idart.framework.rest.RESTClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * iDARTweb index controller
 */
@Controller
class IndexController {
    
    @Value('${external.base.url}')
    def String externalBaseUrl
    
    @Inject
    RESTClient client;

    @RequestMapping(value="/", method = RequestMethod.GET)
    def root(Model model) {
        return index(model);
    }

    @RequestMapping(value="/ui", method = RequestMethod.GET)
    def index(Model model) {
        return "ui/index";
    }
    
    @RequestMapping(value="/ui/dashboard", method = RequestMethod.GET)
    def dashboard(Model model) {
        return "ui/dashboard";
    }
}