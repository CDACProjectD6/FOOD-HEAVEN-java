package com.app.entity;

import javax.persistence.*;


@Entity
@Table(name="addresses")
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
}
