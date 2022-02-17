package com.github.juliherms.product.service;

import com.github.juliherms.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * This class responsible to load products in the database
 */
@Service
public class DataSetupService implements CommandLineRunner {

    @Autowired
    private ProductService service;

    @Override
    public void run(String... args) throws Exception {
        ProductDTO p1 = new ProductDTO("4K-TV", BigDecimal.TEN);
        ProductDTO p2 = new ProductDTO("4K-TV", BigDecimal.TEN);
        ProductDTO p3 = new ProductDTO("4K-TV", BigDecimal.TEN);

        //insert products by flux
        Flux.just(p1,p2,p3)
                .flatMap(p -> this.service.insert(Mono.just(p)))
                .subscribe(System.out::println);
    }
}
