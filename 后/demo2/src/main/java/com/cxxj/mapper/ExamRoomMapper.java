package com.cxxj.mapper;

import com.cxxj.model.ExamRoom;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ExamRoomMapper {
    int deleteByPrimaryKey(Long examRoomId);

    int insert(ExamRoom record);

    int insertSelective(ExamRoom record);

    ExamRoom selectByPrimaryKey(Long examRoomId);

    int updateByPrimaryKeySelective(ExamRoom record);

    int updateByPrimaryKey(ExamRoom record);

    List<ExamRoom> findAllExamRoom(@Param("map") HashMap<String, String> queryMap);


}