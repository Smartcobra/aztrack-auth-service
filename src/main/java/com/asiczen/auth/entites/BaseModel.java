package com.asiczen.auth.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {

    @Id
    private String id;

    private boolean deleted;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }
}
