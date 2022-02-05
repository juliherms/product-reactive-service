package com.github.juliherms.product.controller;

import com.github.juliherms.product.dto.ProductDTO;
import com.github.juliherms.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("all")
    public Flux<ProductDTO> all(){
        return this.service.getAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<ProductDTO>> getById(@PathVariable  String id){
        return  this.service.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ProductDTO> insert(@RequestBody Mono<ProductDTO> productDTOMono) {
        return this.service.insert(productDTOMono);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<ProductDTO>> update(@PathVariable String id, @RequestBody Mono<ProductDTO> productDTOMono){
        return this.service.update(id,productDTOMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<Void> delete(@PathVariable String id){
        return this.service.delete(id);
    }
}
