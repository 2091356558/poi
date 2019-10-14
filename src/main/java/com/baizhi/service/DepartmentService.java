package com.baizhi.service;

import com.baizhi.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    public List<Department> selectAllDepartment();
    public Integer selectCount();
    //分页
    public List<Department> selectPageAll(@Param("start")Integer start, @Param("rows")Integer rows);
    //添加部门
    public void addDepartment(Department department);
    //修改部门
    public void updateDepartment(Department department);
    //删除部门
    public void deleteDepartment(Department department);
}
