package com.example.servingwebcontent.mapper;
import com.example.servingwebcontent.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {
//    @Insert("create table public.user_03( id INT AUTO_INCREMENT primary key , account_id varchar, name varchar, token varchar, gmt_creat bigint, gmt_modified bigint)")

    @Insert("insert into user01 (name,account_id,token,gmt_creat,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user01 where token = #{token}")
    User findByToken(@Param("token") String token);

}
