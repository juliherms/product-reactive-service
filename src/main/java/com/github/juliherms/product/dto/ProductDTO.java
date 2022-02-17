package com.github.juliherms.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private String description;
    private BigDecimal price;

    public ProductDTO(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }
}
