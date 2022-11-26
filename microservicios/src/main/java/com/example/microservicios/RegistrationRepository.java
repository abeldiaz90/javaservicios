package com.example.microservicios;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.example.microservicios.Student;
@Repository
public interface RegistrationRepository extends  ReactiveMongoRepository<Student, String>{
}