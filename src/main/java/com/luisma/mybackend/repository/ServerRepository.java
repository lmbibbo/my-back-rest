package com.luisma.mybackend.repository;

import com.luisma.mybackend.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);
}