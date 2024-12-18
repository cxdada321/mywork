package edu.hust.controller;

import edu.hust.pojo.Emp;
import edu.hust.pojo.PageBean;
import edu.hust.pojo.Result;
import edu.hust.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    private Logger log = LoggerFactory.getLogger(EmpController.class);

    /**
     * 分页查询员工
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate end) {
        log.info("分页查询参数：{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        //调用service
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 删除员工
     * @param ids
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除员工id：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("添加员工：{}", emp);
        empService.add(emp);
        return Result.success();
    }

}

