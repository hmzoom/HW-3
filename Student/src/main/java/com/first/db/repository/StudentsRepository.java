package com.first.db.repository;

import com.first.db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
    Student findFirstByName(String name);
}
