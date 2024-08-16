package com.app.request;

import java.time.LocalDateTime;
import java.util.List;

import com.app.entity.Address;
import com.app.entity.ContactInformation;

import lombok.Data;

@Data
public class CreateRestaurantRequest {
   private Long id;
   private String name;
   private String description;
   private String cuisineType;
   private Address address;
   private ContactInformation contactInformation;
   private String openingHours;
   private List<String>images;
  
}
