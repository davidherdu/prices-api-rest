package com.david.zara.prices.repository;

import com.david.zara.prices.model.Price;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	@Query("SELECT p "
		+ "FROM Price p "
		+ "WHERE :date >= p.startDate AND :date <= p.endDate "
		+ "AND p.productId = :productId "
		+ "AND p.brandId = :brandId")     
	public List<Price> findPrices(
		@Param("date") LocalDateTime data, 
		@Param("productId") Long productId, 
		@Param("brandId") Long brandId, 
		Sort sort);
}
