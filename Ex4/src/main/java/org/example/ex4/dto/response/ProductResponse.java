package org.example.ex4.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.ex4.dto.ProductDTO;
import org.example.ex4.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
@Builder
public class ProductResponse {
    MetaData metaData;
    List<ProductDTO> products;
}