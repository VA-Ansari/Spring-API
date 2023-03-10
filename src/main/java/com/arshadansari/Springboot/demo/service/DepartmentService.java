package com.arshadansari.Springboot.demo.service;

import com.arshadansari.Springboot.demo.Error.DepartmentNotFoundException;
import com.arshadansari.Springboot.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);

}
