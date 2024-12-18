package edu.hust.service;


import edu.hust.pojo.Emp;
import edu.hust.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询员工
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加员工
     * @param emp
     */
    void add(Emp emp);

    /**
     * 登录
     * @param emp
     */
    Emp login(Emp emp);
}
