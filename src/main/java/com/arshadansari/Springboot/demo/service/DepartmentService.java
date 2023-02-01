package com.arshadansari.Springboot.demo.service;

import com.arshadansari.Springboot.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();
}
