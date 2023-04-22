package com.david.zara.prices.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.david.zara.prices.model.Price;

public interface PriceService {

    public Optional<Price> searchPrice(LocalDateTime appDate, Long productId, Long brandId);
}
