package com.accres.property.management.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private Long pid;
    private String propertyType;
    private Double price;
    private String description;
    private String location;
}
