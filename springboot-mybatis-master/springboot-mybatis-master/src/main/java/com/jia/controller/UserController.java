package com.jia.controller;

import com.jia.mapper.UserMapper;
import com.jia.pojo.User;
import com.jia.service.UserService;
import com.jia.vo.ReponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ReponseBody login(@RequestBody  User user){
        return userService.login(user);
    }

    @PostMapping("/regist")
    @ResponseBody
    public ReponseBody regist(@RequestBody User user){
        return userService.regist(user);
    }



    //查询所有
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user :userList){
            System.out.println(user);
        }
        return  userList;

    }

    //查询所有
    @GetMapping("/query/{id}")
    public User queryUser(@PathVariable long id){
        return  userMapper.queryUserById(id);
    }

    //添加
    @GetMapping("/addUser")
    public String addUser(User user){
        userMapper.addUser(user);
     return "ok";
    }
    //根据ID删除
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id){
        userMapper.deleteUser(25);
        return "ok";
    }
    //修改
    @GetMapping("/updateUser")
    public String updateUser(User user){
        userMapper.updateUser(user);
        return "ok";
    }



}
