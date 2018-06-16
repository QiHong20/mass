package com.example.demomultisourceofmybatis.mapper1;


import com.example.demomultisourceofmybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Transactional("transactionManager1")
public interface UserMapper {

    @Select("select name,age from user where name = #{name}")
    User getByName(String name);

    @Update("update user set age =#{age} where name = #{name}")
    void update(@Param("name") String name, @Param("age") int age);
}
