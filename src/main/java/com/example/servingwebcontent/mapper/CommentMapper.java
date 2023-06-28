package com.example.servingwebcontent.mapper;

import com.example.servingwebcontent.model.Comment;
import com.example.servingwebcontent.model.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    long countByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int deleteByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int insert(Comment row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int insertSelective(Comment row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    List<Comment> selectByExampleWithRowbounds(CommentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    List<Comment> selectByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    Comment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByExampleSelective(@Param("row") Comment row, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByExample(@Param("row") Comment row, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByPrimaryKeySelective(Comment row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENT
     *
     * @mbg.generated Wed Jun 28 20:35:25 CST 2023
     */
    int updateByPrimaryKey(Comment row);
}