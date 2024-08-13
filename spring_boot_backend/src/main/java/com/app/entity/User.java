package com.app.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;
import com.app.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String email;
	
	private String password;
	
	private USER_ROLE role= USER_ROLE.ROLE_CUSTOMER;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Order> orders = new ArrayList<>(); 
	
	@ElementCollection
	private List<RestaurantDto> favourites = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Address> address = new ArrayList<>();
	
	
}
 



















