package com.example.servingwebcontent.mapper;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int insert(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int insertSelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByExample(@Param("row") User row, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER01
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByPrimaryKey(User row);
}