package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Controller
@RequestMapping("dep")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @ResponseBody
    @RequestMapping("selectAll")
    public void selectAll(HttpServletResponse response) throws IOException {
        List<Department> departments = departmentService.selectAllDepartment();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<select>");
        response.setContentType("text/html;charset=utf-8");
        for (Department dept : departments) {
            String option = "<option value=\"" + dept.getId() + "\">" + dept.getDepartment_name() + "</option>";
            stringBuilder.append(option);
        }
        stringBuilder.append("</select>");
        String s = stringBuilder.toString();
        response.getWriter().print(s);
    }
    @ResponseBody
    @RequestMapping("selectAllDepartment")
    public Map<String, Object> selectAllDepartment(Integer page, Integer rows) {
        Integer total = departmentService.selectCount();//总条数
        Integer totalpage = total % rows == 0 ? total / rows : total / rows + 1;  //总页数
        List<Department> departmentMappers = departmentService.selectPageAll(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", totalpage); //总页数
        map.put("page", page);   //当前页
        map.put("records", total);  //总条数
        map.put("rows", departmentMappers);  //展示的数据
        return map;
    }
    @ResponseBody
    @RequestMapping("edit")
    public void edit(String oper,Department department){
        if("add".equals(oper)){
            department.setId(UUID.randomUUID().toString().replace("-",""));
            departmentService.addDepartment(department);
        }else if("del".equals(oper)){
            departmentService.deleteDepartment(department);
        }else{
            departmentService.updateDepartment(department);
        }
    }
}