package com.authservice.demo.repository;

import com.authservice.demo.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<String, UUID> {
    Optional<User> findByEmail(String email);
}