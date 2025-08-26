

package com.example.skillswap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true, nullable = false)
    @NotBlank
    private String username;


    @Column(nullable = false)
    @NotBlank
    private String password; // BCrypt encoded


    @Column(nullable = false)
    private String role; // "USER" or "ADMIN"
}