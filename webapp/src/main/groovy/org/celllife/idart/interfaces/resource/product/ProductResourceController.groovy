package org.celllife.idart.interfaces.resource.product

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.product.dto.ProductDto
import org.celllife.idart.common.ProductId
import org.celllife.idart.domain.product.ProductNotFoundException
import org.celllife.idart.domain.product.ProductValidationException
import org.celllife.idart.security.product.ProductSecurityAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 */
@Controller class ProductResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(ProductResourceController)

    @Inject ProductSecurityAdapter productSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET, produces = "application/json")
    ProductDto findByProductId(@PathVariable("productId") ProductId productId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return productSecurityAdapter.findByProductId(principal, productId)

        } catch (ProductNotFoundException ignore) {
            LOGGER.error("Could not find Product with id "+productId, ignore)
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    void save(@RequestBody ProductDto productDto, Principal principal, HttpServletResponse response) {

        try {

            ProductId productId = productSecurityAdapter.save(principal, productDto)

            response.setHeader("Location", "${baseUrl}/products/${productId}")
            response.setStatus(SC_CREATED)

        } catch (ProductValidationException e) {
            LOGGER.error("Could not save Product "+productDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
