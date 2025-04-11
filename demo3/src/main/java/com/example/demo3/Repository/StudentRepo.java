package com.example.demo3.Repository;

import com.example.demo3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
