package com.sda.ams.repository;
import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sda.ams.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{


}
