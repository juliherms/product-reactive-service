package com.github.juliherms.product.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class ProductDTO {

    private String id;
    private String description;
    private BigDecimal price;
}
