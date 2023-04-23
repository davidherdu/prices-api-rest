package com.david.zara.prices.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.david.zara.prices.repository.PriceRepository;
import com.david.zara.prices.dto.model.PriceDto;
import com.david.zara.prices.model.Price;
import com.david.zara.prices.exception.EntityType;
import com.david.zara.prices.exception.ExceptionType;
import com.david.zara.prices.exception.PriceException;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PriceRepository priceRepository;

	@Override
	public PriceDto searchPrice(LocalDateTime appDate, Long productId, Long brandId) {
		Optional<Price> price = priceRepository
			.findPrices(appDate, productId, brandId, Sort.by("priority").descending())
			.stream()
			.findFirst();
		
		return price.map(c -> modelMapper.map(c, PriceDto.class))
			.orElseThrow(() -> PriceException.throwException(
				EntityType.PRICE, 
				ExceptionType.ENTITY_NOT_FOUND, 
				String.valueOf(productId),
				String.valueOf(brandId), 
				appDate.toString()
			)
		);
	}
}
