package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.entity.UserDetails;

@Repository
public interface UsersRepository extends JpaRepository<UserDetails, Long> {

}
