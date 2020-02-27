package com.winterchen.demo.dao;


import com.winterchen.demo.model.UserDomain;
import java.util.List;

public interface UserDao {


    int insert(UserDomain record);



    List<UserDomain> selectUsers();
}