package com.first.db.repository;

import com.first.db.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Integer> {
    Course findFirstByName(String name);
}
