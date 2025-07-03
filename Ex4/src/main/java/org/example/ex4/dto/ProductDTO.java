package org.example.ex4.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductDTO {
    Integer id;
    String name;
    Double price;
    Integer categoryId;
    String categoryName;
}
