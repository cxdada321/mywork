package edu.hust.service;


import edu.hust.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     *
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     */
    Dept get(Integer id);


    /**
     * 更新部门
     * @param dept
     */
    void update(Dept dept);


}
