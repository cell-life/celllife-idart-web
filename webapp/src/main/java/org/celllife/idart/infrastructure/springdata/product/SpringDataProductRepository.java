package org.celllife.idart.infrastructure.springdata.product;

import org.celllife.idart.common.ProductId;
import org.celllife.idart.domain.product.Product;
import org.celllife.idart.domain.product.ProductRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 */
public interface SpringDataProductRepository extends ProductRepository,
        PagingAndSortingRepository<Product, ProductId> {

}
