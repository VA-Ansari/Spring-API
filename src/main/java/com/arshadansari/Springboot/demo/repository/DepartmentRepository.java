package com.arshadansari.Springboot.demo.repository;

import com.arshadansari.Springboot.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
