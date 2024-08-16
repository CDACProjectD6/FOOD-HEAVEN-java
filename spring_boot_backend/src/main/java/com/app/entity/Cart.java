package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="carts")
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private User customer;
	
	private Long total;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,orphanRemoval=true)
	private List<CartItem> item = new ArrayList<>();
	
}
