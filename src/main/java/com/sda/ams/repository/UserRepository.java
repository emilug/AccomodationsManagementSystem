package com.sda.ams.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda.ams.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);

}
