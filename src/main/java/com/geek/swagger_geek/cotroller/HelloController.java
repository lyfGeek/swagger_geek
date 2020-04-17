package com.geek.swagger_geek.cotroller;

import com.geek.swagger_geek.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // 只要接口中存在实体类，就会被扫描到 Swagger 中。
//    Models
    @PostMapping("/user")
    public User user() {
        return new User();
    }

    // operation。接口。不是放在类上的。
    @ApiOperation("Hello 控制类。")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username) {
        return "hello" + username;
    }

    // operation。接口。不是放在类上的。
    @ApiOperation("POST 测试。")
    @PostMapping("/postt")
    public User hello3(@ApiParam("用户名") User user) {
        return user;
    }
}
