package com.xupt.read.mapper;

import com.xupt.read.model.Note;
import com.xupt.read.model.NoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    long countByExample(NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int deleteByExample(NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int insert(Note record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int insertSelective(Note record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    List<Note> selectByExample(NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    Note selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByPrimaryKeySelective(Note record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notes
     *
     * @mbg.generated Wed Nov 16 01:09:17 CST 2022
     */
    int updateByPrimaryKey(Note record);
}