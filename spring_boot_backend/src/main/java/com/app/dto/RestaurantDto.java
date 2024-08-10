package com.app.dto;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RestaurantDto {

	private String title;
	
//	@Column(length=1000)
//	private List<String> images;
	
	private String descriptions;
	
	private Long id;
}
