package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserAddress;
import com.example.demo.entity.Users;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

	Optional<UserAddress> findByUserId(Users users);

}
