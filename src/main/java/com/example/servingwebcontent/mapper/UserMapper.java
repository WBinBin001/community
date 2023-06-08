package com.example.servingwebcontent.mapper;
import com.example.servingwebcontent.model.User;
import org.apache.ibatis.annotations.*;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {
//    @Insert("create table public.user_03( id INT AUTO_INCREMENT primary key , account_id varchar, name varchar, token varchar, gmt_creat bigint, gmt_modified bigint)")

    @Insert("insert into user01 (name,account_id,token,gmt_creat,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user01 where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user01 where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user01 where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user01 set name = #{name}, token = #{token}, gmt_modified = #{gmtModified},avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);


}
