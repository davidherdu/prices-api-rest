package com.david.zara.prices.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.david.zara.prices.exception.PriceNotFoundException;
import com.david.zara.prices.model.Price;
import com.david.zara.prices.payload.PriceDto;
import com.david.zara.prices.service.PriceService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("/api/prices")
@Tag(name = "Prices", description = "Prices operations")
public class PriceController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping
	@ApiResponse(responseCode = "200", description = "Price found for current input data", content = @Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = PriceDto.class)))
	@ApiResponse(responseCode = "404", description = "No prices found for the current input parameters", content = @Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class)))
	public ResponseEntity<PriceDto> getPrices(
		@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) final LocalDateTime appDate, 
		@RequestParam Long productId,
		@RequestParam Long brandId) {
				
		Optional<Price> price = priceService.searchPrice(appDate, productId, brandId);

		return price.map(c -> ResponseEntity.ok().body(modelMapper.map(c, PriceDto.class)))
					.orElseThrow(() -> new PriceNotFoundException(appDate, productId, brandId));                
	}
}
