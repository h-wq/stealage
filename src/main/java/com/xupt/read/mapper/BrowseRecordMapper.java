package com.xupt.read.mapper;

import com.xupt.read.model.BrowseRecord;
import com.xupt.read.model.BrowseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrowseRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    long countByExample(BrowseRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int deleteByExample(BrowseRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int insert(BrowseRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int insertSelective(BrowseRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    List<BrowseRecord> selectByExample(BrowseRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    BrowseRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByExampleSelective(@Param("record") BrowseRecord record, @Param("example") BrowseRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByExample(@Param("record") BrowseRecord record, @Param("example") BrowseRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByPrimaryKeySelective(BrowseRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browse_record
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByPrimaryKey(BrowseRecord record);
}