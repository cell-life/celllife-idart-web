package org.celllife.idart.interfaces.resource.product

import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.product.Product
import org.celllife.idart.domain.product.ProductNotFoundException
import org.celllife.idart.domain.product.ProductValidationException
import org.celllife.idart.security.product.ProductSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class ProductResourceController {

    @Inject ProductSecurityAdapter productSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/products/{productId}", method = GET, produces = "application/json")
    Product findByProductId(@PathVariable("productId") ProductId productId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            productSecurityAdapter.findByProductId(principal, productId)

        } catch (ProductNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/products", method = POST)
    void save(@RequestBody Product product, Principal principal, HttpServletResponse response) {

        try {

            product = productSecurityAdapter.save(principal, product)

            response.setHeader("Location", "${baseUrl}/products/${product.id}")
            response.setStatus(SC_CREATED)

        } catch (ProductValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
