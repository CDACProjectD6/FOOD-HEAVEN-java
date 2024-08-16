package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String discriptions;
	
	private Long price;
	
	@ManyToOne
	private Category foodCategory;
	
	@Column(length = 1000)
	@ElementCollection
	private List<String> images;
	
	private boolean available;
	
	@ManyToOne
	private Restaurant restaurant;
	
	private boolean isVegetarian;
	
	private boolean isSeasonal;
	
	@ManyToMany
	private List<IngredientsItem> ingredient = new ArrayList<>();
	
	private LocalDate creationDate;
}







