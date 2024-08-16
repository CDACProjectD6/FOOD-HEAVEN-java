package com.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurants")
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private User owner;
	
	private String name;
	
	private String descriptions;
	
	private String cuisineType;
	
	@OneToOne
	private Address address;
	
	@Embedded
	private ContactInformation contactInformation;
	
	private String openingHours;
	
	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();
	
	@Column(length = 1000)
	@ElementCollection
	private List<String> images; 
	
	private LocalDateTime registrationDate;
	
	private boolean open;
	
	@JsonIgnore
	@OneToMany(mappedBy="restaurant", cascade = CascadeType.ALL)
	private List<Food> foods = new ArrayList<>();
	
	
}















