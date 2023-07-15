package com.accres.property.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OWNER_TABLE")
@Getter
@Setter
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "OWNER_ID")
    private Long ownerId;
    private String ownerName;

    @Column(name = "OWNER_EMAIl", nullable = false)
    private String ownerEmail;
    private Double phone;
    private String password;
}
