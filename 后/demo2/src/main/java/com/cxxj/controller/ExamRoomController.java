package com.cxxj.controller;

import com.cxxj.base.JsonResponse;
import com.cxxj.model.ExamRoom;
import com.cxxj.service.ExamRoomService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RequestMapping("/examRoom")
@Controller
public class ExamRoomController {

    @Autowired
    private ExamRoomService examRoomService;

    //分页查询所有用户
    @ApiOperation(value = "分页查询全部数据", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "INTEGER", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "最大条数", required = true, dataType = "INTEGER", paramType = "query", defaultValue = "7")
    })
    @GetMapping("/findExamRoomPage")
    @ResponseBody
    public JsonResponse findExamRoomPage (@RequestParam HashMap<String, String> queryMap, int pageNum, int pageSize) throws Exception {
        PageInfo pageInfo = examRoomService.findExamRoomPage(queryMap,pageNum, pageSize);
        JsonResponse jsonResponse = new JsonResponse(0,"成功",pageInfo);
        return jsonResponse;
    }

    //添加用户
    @ApiOperation(value = "添加", httpMethod = "POST")
    @PostMapping("/addExamRoom")
    @ResponseBody
    public JsonResponse addExamRoom(@RequestBody ExamRoom ExamRoom) throws Exception {
        JsonResponse jsonResponse = new JsonResponse();
        int ret = examRoomService.insertSelective(ExamRoom);
        if ( 1 != ret ) {
            return new JsonResponse(1,"添加失败");
        }
        return new JsonResponse(0,"添加成功");
    }

    //更新用户
    @ApiOperation(value = "修改信息", httpMethod = "PUT")
    @PutMapping("/updateExamRoom")
    @ResponseBody
    public JsonResponse updateExamRoom(@RequestBody ExamRoom ExamRoom) throws Exception {
        int ret =  examRoomService.updateByPrimaryKeySelective(ExamRoom);
        if ( 1 != ret ) {
            return new JsonResponse(1,"更新失败");
        }
        return new JsonResponse(0,"更新成功");
    }

    //删除用户
    @ApiOperation(value = "删除", httpMethod = "PUT")
    @PutMapping("/deleteExamRoom/{id}")
    @ResponseBody
    public JsonResponse deleteExamRoom(@PathVariable Long id) throws Exception {
        int ret =  examRoomService.deleteByPrimaryKey(id);
        if ( 1 != ret ) {
            return new JsonResponse(1,"删除失败");
        }
        return new JsonResponse(0,"删除成功");
    }


}
