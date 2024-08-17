package com.spring.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_order_id", referencedColumnName = "id")
    @JsonManagedReference
    private Order order;
}
