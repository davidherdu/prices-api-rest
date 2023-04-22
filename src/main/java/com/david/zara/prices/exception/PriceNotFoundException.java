package com.david.zara.prices.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {
	
	public PriceNotFoundException(LocalDateTime appDate, Long productId, Long brandId) {
        super(String.format("Price for productId %s, brandId %s at %s not found : ", productId, brandId, appDate));
    }
}
