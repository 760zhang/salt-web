package com.jia.mapper;

import com.jia.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示本类是一个mybatis的mapper类:  Dao
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(long id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(long id);
    User findByName(String name);
    String findPswByName(String UserName);

}
