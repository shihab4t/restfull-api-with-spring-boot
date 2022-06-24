package com.sh048b.restapi.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // SELECT * FROM students WHERE email = passedEmail
    Optional<Student> findStudentByEmail(String email);
}
