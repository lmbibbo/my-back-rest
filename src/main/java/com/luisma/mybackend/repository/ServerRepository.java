package com.luisma.mybackend.repository;

import com.luisma.mybackend.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ServerRepository extends MongoRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);
}