package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AuthenticationDetails;
import com.example.demo.entity.Users;
import com.example.demo.enums.Status;

@Repository
public interface AuthenticationDetailsRepository extends JpaRepository<AuthenticationDetails, Long> {

	Optional<AuthenticationDetails> findByToken(String token);

	List<AuthenticationDetails> findByUserId(Users users);

	Optional<AuthenticationDetails> findByUserIdAndStatus(Users user, Status string);

	Optional<AuthenticationDetails> findByTokenAndStatus(String jwt, Status name);



}
