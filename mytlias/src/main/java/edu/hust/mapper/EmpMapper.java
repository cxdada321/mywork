package edu.hust.mapper;

import edu.hust.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询员工总数
     * @return
     */
    /*@Select("select count(*) from emp ")
    public Long count();*/

    /**
     * 条件分页查询员工，获取列表数据
     * @param start
     * @param size
     * @return
     */
    /*@Select("select * from emp limit #{start},#{size}")
    public List<Emp> page(Integer start, Integer size);*/

    /**
     * 查询所有
     * @return
     */
    /*@Select("select * from emp where name like concat('%',#{name},'%')\n" +
            "        and gender = #{gender} and entrydate between #{begin} and #{end}\n" +
            "        order by update_time desc")*/
    public List<Emp> get(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 删除员工
     * @param ids
     */

    void delete(List<Integer> ids);

    /**
     * 添加员工
     * @param emp
     */
    @Insert("insert into tlias.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "value (#{username} ,#{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void add(Emp emp);

    /**
     * 登录
     * @param emp
     * @return
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
