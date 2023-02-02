package com.arshadansari.Springboot.demo.service;

import com.arshadansari.Springboot.demo.Error.DepartmentNotFoundException;
import com.arshadansari.Springboot.demo.entity.Department;
import com.arshadansari.Springboot.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceIpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> fetchDepartment =  departmentRepository.findById(departmentId);

        //if department of thatid is not present, then return that error
        if (!fetchDepartment.isPresent())
            throw new DepartmentNotFoundException("Department Not Available");

        return fetchDepartment.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        //just checkin if anything notnull and blank, then only update value otherwise skip it
        if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
