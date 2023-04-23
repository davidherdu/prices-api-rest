package com.david.zara.prices.service;

import java.time.LocalDateTime;

import com.david.zara.prices.dto.model.PriceDto;

public interface PriceService {

    public PriceDto searchPrice(LocalDateTime appDate, Long productId, Long brandId);
}
