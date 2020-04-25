package com.xupt.read.mapper;

import com.xupt.read.model.Note;
import com.xupt.read.model.NoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    long countByExample(NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int deleteByExample(NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int insert(Note record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int insertSelective(Note record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    List<Note> selectByExample(NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    Note selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByPrimaryKeySelective(Note record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table note
     *
     * @mbg.generated Sat Apr 25 18:33:59 CST 2020
     */
    int updateByPrimaryKey(Note record);
}