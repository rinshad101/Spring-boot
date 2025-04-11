package com.example.demo3.service;

import com.example.demo3.Repository.StudentRepo;
import com.example.demo3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public List<Student> getAllStudent(){
        return repo.findAll();
    }


    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new RuntimeException("erroeeeeeeeerr"));
    }

    public Student updateStudent(Long id, Student newStudent) {
        Student student = getStudentById(id);
        student.setName(newStudent.getName());
        student.setAge(newStudent.getAge());
        return repo.save(student);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }


    public List<Student> searchBy(String name) {
        if(name != null) return repo.findByNameContainingIgnoreCase(name);
        return Collections.emptyList();
    }

    public Page<Student> sortBy(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return repo.findAll(pageable);
    }
}
