package com.cxxj.service;

import com.cxxj.model.ExamRoom;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.HashMap;


/**
 * ExamRoomService接口类
 * Created: zhangj on 2022/04/05
 * @versionv 1.0
 */

public interface ExamRoomService {

    /**
     * 分页查询
     *
     * @param
     * @return
     */
    PageInfo findExamRoomPage(HashMap<String, String> queryMap, int pageNum, int pageSize) throws Exception ;

    /**
     * 根据主键删除
     *
     * @param  id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存
     *
     * @param record
     * @return
     */
    int insert(ExamRoom record);

    /**
     * 根据条件插入
     *
     * @param record
     * @return
     */
    int insertSelective(ExamRoom record);

    /**
     * 根据主键查询
     *
     * @param  id
     * @return
     */
    ExamRoom selectByPrimaryKey(Long id);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExamRoom record);

    /**
     * 根据条件更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExamRoom record);
}
