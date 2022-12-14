package com.xupt.stealage.mapper;

import com.xupt.stealage.model.Circle;
import com.xupt.stealage.model.CircleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    long countByExample(CircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int deleteByExample(CircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int insert(Circle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int insertSelective(Circle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    List<Circle> selectByExample(CircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    Circle selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByExampleSelective(@Param("record") Circle record, @Param("example") CircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByExample(@Param("record") Circle record, @Param("example") CircleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByPrimaryKeySelective(Circle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circles
     *
     * @mbg.generated Sat Dec 03 15:51:38 CST 2022
     */
    int updateByPrimaryKey(Circle record);
}