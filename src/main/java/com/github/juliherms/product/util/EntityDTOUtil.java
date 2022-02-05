package com.github.juliherms.product.util;

import com.github.juliherms.product.dto.ProductDTO;
import com.github.juliherms.product.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityDTOUtil {

    public static ProductDTO toDTO(Product product){
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product,dto);
        return dto;
    }

    public static Product toEntity(ProductDTO dto){
        Product product = new Product();
        BeanUtils.copyProperties(dto,product);
        return product;
    }
}
