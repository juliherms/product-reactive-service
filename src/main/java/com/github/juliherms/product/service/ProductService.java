package com.github.juliherms.product.service;

import com.github.juliherms.product.dto.ProductDTO;
import com.github.juliherms.product.repository.ProductRepository;
import com.github.juliherms.product.util.EntityDTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * This class responsible to implements logical business
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    /**
     * List all products
     * @return
     */
    public Flux<ProductDTO> getAll(){
        return this.repo.findAll()
                .map(EntityDTOUtil::toDTO);
    }

    /**
     * Return product by id
     * @param id
     * @return
     */
    public Mono<ProductDTO> getById(String id){
        return this.repo.findById(id)
                .map(EntityDTOUtil::toDTO);
    }

    /**
     * Insert product in database
     * @param productDTOMono
     * @return
     */
    public Mono<ProductDTO> insert(Mono<ProductDTO> productDTOMono){
        return productDTOMono
                .map(EntityDTOUtil::toEntity)
                .flatMap(this.repo::insert)
                .map(EntityDTOUtil::toDTO);
    }

    /**
     * Update product in database
     * @param id
     * @param productDTOMono
     * @return
     */
    public Mono<ProductDTO> update(String id, Mono<ProductDTO> productDTOMono){
        return this.repo.findById(id)
                .flatMap(p -> productDTOMono
                        .map(EntityDTOUtil::toEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(this.repo::save)
                .map(EntityDTOUtil::toDTO);
    }

    /**
     * Delete product in database
     * @param id
     * @return
     */
    public Mono<Void> delete(String id){
        return this.repo.deleteById(id);
    }

    /**
     * List all products by range
     * @param min
     * @param max
     * @return
     */
    public Flux<ProductDTO> getProductByPriceRange(BigDecimal min, BigDecimal max){
        return this.repo.findByPriceBetween(Range.closed(min,max))
                .map(EntityDTOUtil::toDTO);
    }

}
