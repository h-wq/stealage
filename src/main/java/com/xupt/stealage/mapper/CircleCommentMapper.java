package com.xupt.stealage.mapper;

import com.xupt.stealage.model.CircleComment;
import com.xupt.stealage.model.CircleCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    long countByExample(CircleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int deleteByExample(CircleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int insert(CircleComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int insertSelective(CircleComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    List<CircleComment> selectByExample(CircleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    CircleComment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByExampleSelective(@Param("record") CircleComment record, @Param("example") CircleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByExample(@Param("record") CircleComment record, @Param("example") CircleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByPrimaryKeySelective(CircleComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_comments
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByPrimaryKey(CircleComment record);
}