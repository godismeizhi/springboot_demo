package com.example.demo.controller;

import com.example.demo.common.R;
import com.example.demo.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "用戶接口", description = "這是一個用戶接口", tags = "用戶接口")
@RequestMapping("/users")
public class UserController {


    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @GetMapping("/users/{id}")
    public R<User> getInfo(@PathVariable("id") Integer id,
                           @ApiParam("第一个id") @RequestParam String id2,
                           @RequestParam int pageNum,
                           int pageSize,
                           double version) {

        return R.getInstance(new User());
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取用户列表信息", notes = "根据url的id来获取用户列表信息")
    public R<List<User>> getInfos() {

        List<User> users = new ArrayList<>();
        users.add(new User());
        return R.getInstance(users);
    }
}
