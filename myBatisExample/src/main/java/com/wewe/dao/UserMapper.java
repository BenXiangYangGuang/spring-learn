package com.wewe.dao;

import com.wewe.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author: fei2
 * Date:  18-9-12 下午2:54
 * Description:
 * Refer To:
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Update("UPDATE USER SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM USER WHERE id =#{id}")
    void delete(Long id);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

}