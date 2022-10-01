package com.cxxj.controller;

import com.cxxj.base.JsonResponse;
import com.cxxj.model.User;
import com.cxxj.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/user")
@Controller
public class userController {

    @Autowired
    private UserService userService;

    //分页查询所有用户
    @ApiOperation(value = "分页查询全部用户", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "INTEGER", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "最大条数", required = true, dataType = "INTEGER", paramType = "query", defaultValue = "7")
    })
    @GetMapping("/findAll")
    @ResponseBody
    public JsonResponse findAllUser(String username, int pageNum, int pageSize) throws Exception {
        PageInfo pageInfo = userService.findAllUser(username,pageNum, pageSize);
        JsonResponse jsonResponse = new JsonResponse(0,"成功",pageInfo);
        return jsonResponse;
    }
    //添加用户
    @ApiOperation(value = "添加新用户", httpMethod = "POST")
    @PostMapping("/addUser")
    @ResponseBody
    public JsonResponse addUser(@RequestBody User user) throws Exception {
        JsonResponse jsonResponse = new JsonResponse();
        int ret = userService.insertSelective(user);
        if ( 1 != ret ) {
            return new JsonResponse(1,"添加失败");
        }
        return new JsonResponse(0,"添加成功");
    }

    //更新用户
    @ApiOperation(value = "修改用户信息", httpMethod = "PUT")
    @PutMapping("/updateUser")
    @ResponseBody
    public JsonResponse updateUser(@RequestBody User user) throws Exception {
        int ret =  userService.updateByPrimaryKeySelective(user);
        if ( 1 != ret ) {
            return new JsonResponse(1,"更新失败");
        }
        return new JsonResponse(0,"更新成功");
    }

    //删除用户
    @ApiOperation(value = "删除用户", httpMethod = "PUT")
    @PutMapping("/deleteUser/{id}")
    @ResponseBody
    public JsonResponse deleteUser(@PathVariable Integer id) throws Exception {
        int ret =  userService.deleteByPrimaryKey(id);
        if ( 1 != ret ) {
            return new JsonResponse(1,"删除失败");
        }
        return new JsonResponse(0,"删除成功");
    }
}
