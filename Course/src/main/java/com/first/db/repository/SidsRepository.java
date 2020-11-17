package com.first.db.repository;

import com.first.db.model.Sid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SidsRepository extends JpaRepository<Sid, Integer> {
    Sid findFirstByStudentId(Integer studentId);
}
