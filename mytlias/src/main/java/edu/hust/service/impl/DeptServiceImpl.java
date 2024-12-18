package edu.hust.service.impl;

import edu.hust.mapper.DeptMapper;
import edu.hust.pojo.Dept;
import edu.hust.service.DeptService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {




    //Service不能进行数据库操作，需要注入Mapper对象
    @Autowired
    private DeptMapper mapper;


    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        mapper.add(dept);
    }

    @Override
    public List<Dept> list() {
        return mapper.list();
    }

    @Override
    public void delete(Integer id) {
        mapper.deleteById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        mapper.update(dept);
    }

    @Override
    public Dept get(Integer id) {
        return mapper.get(id);
    }
}
