package com.cxxj.service.impl;

import com.cxxj.mapper.ExamRoomMapper;
import com.cxxj.model.ExamRoom;
import com.cxxj.service.ExamRoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * ExamRoomService实现类
 * Created: zhangj on 2022/04/05
 * @versionv 1.0
 */

@Service("examRoomService")
public class ExamRoomServiceImpl implements ExamRoomService {

    @Autowired
    private ExamRoomMapper examRoomMapper;

    @Override
    public PageInfo findExamRoomPage (HashMap<String, String> queryMap, int pageNum, int pageSize) throws Exception {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<ExamRoom> ExamRoomList =  examRoomMapper.findAllExamRoom(queryMap);
        PageInfo pageInfo = new PageInfo(ExamRoomList);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return  examRoomMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int insert(ExamRoom record) {
        return examRoomMapper.insert(record);
    }

    @Override
    public int insertSelective(ExamRoom record) {
        return  examRoomMapper.insertSelective(record);
    }

    @Override
    public ExamRoom selectByPrimaryKey(Long id) {
        ExamRoom examRoom =  examRoomMapper.selectByPrimaryKey(id);
        return examRoom;
    }

    @Override
    public int updateByPrimaryKeySelective(ExamRoom record) {
        int ret =  examRoomMapper.updateByPrimaryKeySelective(record);
        return ret;
    }

    @Override
    public int updateByPrimaryKey(ExamRoom record) {
        int ret =  examRoomMapper.updateByPrimaryKey(record);
        return ret;
    }
}
