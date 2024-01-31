package com.jia.service;

import com.jia.mapper.UserMapper;
import com.jia.pojo.User;
import com.jia.vo.ReponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public ReponseBody login(User user){//TODO：登陆逻辑函数
        try {
            User userExistN = userMapper.findByName(user.getUsername());
            if (userExistN != null){
                String userExistP = userMapper.findPswByName(user.getUsername());
                if (userExistP.equals(user.getPassword())){
                    return new ReponseBody(200,null,user.getUsername()+" 用户登录成功,欢迎您！");
                }else {
                    return new ReponseBody(500,null,user.getUsername()+" 用户登录失败！");
                }
            }else {
                return new ReponseBody(500,null,"登陆失败，账户不存在");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ReponseBody(500,null,e.getMessage());
        }
    }

    public ReponseBody regist(User user){//TODO：注册判断逻辑函数
        try{
            User userExist = userMapper.findByName(user.getUsername());
            if (user.getUsername().equals("")){
                return new ReponseBody(500,null," 账户名不能为空");
            }else if (user.getPassword().equals("")){
                return new ReponseBody(500,null," 密码不能为空");
            }else if (userExist != null){
                return new ReponseBody(500,null," 账户已经存在");
            }else {
                userMapper.addUser(user);
                return new ReponseBody(200,null,"注册成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ReponseBody(500,null,e.getMessage());
        }
    }
}
