package com.accres.property.management.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private Long pid;
    private String propertyType;
  //  private String description;
    private String ownerName;
   // private String ownerEmail;
    private Double price;
    private String location;
}
