package com.example.HelloWorld.Repo;

import com.example.HelloWorld.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EnableWebSecurity
@Repository
public interface StudentRepo extends MongoRepository<Student,String> {
    Optional<Student> findByUsername(String username);

    Boolean existsByusername(String username);

    Boolean existsByEmail(String email);

}
