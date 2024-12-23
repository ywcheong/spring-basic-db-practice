package com.ywcheong.test.simpledatabase.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductRequestDTO {
    private String name;
    private Integer price;
    private Integer stock;
}
