package com.github.juliherms.product.repository;

import com.github.juliherms.product.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

    /**
     * Method responsible to list all products by min and max price
     * @param min
     * @param max
     * @return
     */
    Flux<Product> findByPriceBetween(int min, int max);

    /**
     * Method responsible to list all products by min and max price
     * @param range value init and value end
     * @return
     */
    Flux<Product> findByPriceBetween(Range<BigDecimal> range);
}
