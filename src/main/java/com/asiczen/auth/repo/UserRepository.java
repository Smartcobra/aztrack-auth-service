package com.asiczen.auth.repo;


import com.asiczen.auth.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserName(String login);
}
