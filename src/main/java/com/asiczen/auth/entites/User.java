package com.asiczen.auth.entites;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "app_user")
public class User {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    @Column(name = "first_name", nullable = false)
    @Size(max = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(max = 100)
    private String lastName;

    @Column(name = "user_name",nullable = false)
    @Size(max = 100)
    private String userName;

    @Column(nullable = false)
    @Size(max = 100)
    private String password;


    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

}
