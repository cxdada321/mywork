package edu.hust.mapper;


import edu.hust.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    @Insert("insert into dept(name,create_Time,update_Time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     */
    @Select("select * from dept where id = #{id}")
    Dept get(Integer id);

    /**
     * 更新部门
     * @param dept
     */
    @Update("update dept set name= #{name}, update_Time = #{updateTime} where id = #{id}")
    void update(Dept dept);


}
