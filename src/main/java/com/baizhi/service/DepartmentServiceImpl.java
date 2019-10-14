package com.baizhi.service;

import com.baizhi.entity.Department;
import com.baizhi.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer selectCount() {
        return departmentMapper.selectCount();
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Department> selectPageAll(Integer start, Integer rows) {
        return departmentMapper.selectPageAll(start,rows);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentMapper.deleteDepartment(department);
    }
}
