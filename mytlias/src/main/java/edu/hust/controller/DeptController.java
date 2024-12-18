package edu.hust.controller;

import edu.hust.pojo.Dept;
import edu.hust.pojo.Result;
import edu.hust.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    //注入服务对象
    private DeptService deptService;
    //日志记录
    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    //查询部门数据
    //@RequestMapping("/depts")
    @GetMapping
    public Result list(){
        log.info("查询所有部门");
        List<Dept> depts = deptService.list();
        return Result.success(depts);
    }

    /**
     * 删除部门
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        //调用服务层方法
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 添加部门
     * @return
     */
    @PostMapping
    //利用一个实体作为参数，接收前端传递的数据
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询部门：{}",id);
        Dept dept = deptService.get(id);
        return Result.success(dept);
    }

    /**
     * 更新部门
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("更新部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
