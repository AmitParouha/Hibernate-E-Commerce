package com.spring.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roleType;

    // Bi-Directional mapping
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> userSet = new HashSet<>();
}
