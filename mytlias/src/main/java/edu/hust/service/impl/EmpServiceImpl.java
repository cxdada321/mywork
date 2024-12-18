package edu.hust.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.hust.mapper.EmpMapper;
import edu.hust.pojo.Emp;
import edu.hust.pojo.PageBean;
import edu.hust.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    /**
     * 登录
     * @param emp
     * @return
     */
    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }

    /**
     * 添加员工
     * @param emp
     */
    @Override
    public void add(Emp emp) {
        //补充基本信息
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    /**
     * 删除员工
     * @param ids
     */
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Autowired
    private EmpMapper empMapper;


    /*@Override
    public PageBean page(Integer page, Integer pageSize) {
        PageBean pageBean = new PageBean();

        pageBean.setTotal(empMapper.count());
        pageBean.setRows(empMapper.page((page - 1) * pageSize, pageSize));
        return pageBean;
    }*/

    //封装对象，可以加入依赖PageHelper来简化分页流程，对数据就只需要查询即可，不需要自己进行分页操作
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);

        //查询数据
        List<Emp> emps = empMapper.get(name, gender, begin, end);
        //强转
        Page<Emp> p = (Page<Emp>) emps;

        //封装数据
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }
}
