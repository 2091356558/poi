package com.baizhi.mapper;

import com.baizhi.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
     List<Department> selectAllDepartment();
     Integer selectCount();
    //分页
     List<Department> selectPageAll(@Param("start")Integer start,@Param("rows")Integer rows);
    //添加部门
     void addDepartment(Department department);
    //修改部门
     void updateDepartment(Department department);
    //删除部门
     void deleteDepartment(Department department);
}
