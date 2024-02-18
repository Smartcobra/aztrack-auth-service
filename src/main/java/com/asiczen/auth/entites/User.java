package com.asiczen.auth.entites;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User extends BaseModel {

    private String userName;
    private String email;
    private String password;
    private boolean isDeleted;
    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    private boolean isEmailVerified;

}
