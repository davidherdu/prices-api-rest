package com.david.zara.prices.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.david.zara.prices.repository.PriceRepository;

import com.david.zara.prices.model.Price;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Override
    public Optional<Price> searchPrice(LocalDateTime appDate, Long productId, Long brandId) {
		return priceRepository
				.findPrices(appDate, productId, brandId, Sort.by("priority").descending())
				.stream()
				.findFirst();
    }
}
