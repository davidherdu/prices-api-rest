package com.david.zara.prices.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prices") 
public class Price {
	
	@Id @GeneratedValue @Column(name = "id")
    private Long id;
	
    @Column(name = "brand_id")
    private Long brandId;
	
    @Column(name = "start_date")
    private LocalDateTime startDate;
	
    @Column(name = "end_date")
    private LocalDateTime endDate;
	
    @Column(name = "price_list")
    private Long priceList;
	
    @Column(name = "product_id")
    private Long productId;
	
    @Column(name = "priority")
    private Integer priority;
	
    @Column(name = "price")
    private Double price;
	
    @Column(name = "currency")
    private String currency;
}
