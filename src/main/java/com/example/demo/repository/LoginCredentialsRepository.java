package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginCredentials;
import com.example.demo.entity.Users;

@Repository
public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials, Long> {

	Optional<LoginCredentials> findByUserId(Users users);

}
