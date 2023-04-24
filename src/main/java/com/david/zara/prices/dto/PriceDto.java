package com.david.zara.prices.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PriceDto {
    private Long id;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;
}
