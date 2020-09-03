package com.example.demo.mapper;

import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getByEmployeeId(Integer id);

    @Update("UPDATE employee SET last_name = #{lastName},email = #{email},gender=#{gender},did=#{did} WHERE id = #{id}")
    public int updateEmployee(Employee employee);

    @Delete("DELETE FROM employee where id = #{id}")
    public void deleteEmployee(Integer id);
}
