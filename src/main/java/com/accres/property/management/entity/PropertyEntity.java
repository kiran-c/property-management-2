package com.accres.property.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "P_ID")
    private Long pid;

    private String propertyType;
    //  private String description;
    private String ownerName;
    // private String ownerEmail;
    private Double price;
    private String location;
}
