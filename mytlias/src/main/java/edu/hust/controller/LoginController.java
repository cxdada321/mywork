package edu.hust.controller;

import edu.hust.pojo.Emp;
import edu.hust.pojo.Result;
import edu.hust.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;
    private Logger log = LoggerFactory.getLogger(EmpController.class);

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("登录员工：{}", emp);
        Emp e = empService.login(emp);
        return e != null ? Result.success() : Result.error("用户名或密码错误");
    }

}
