package com.sky.controller;

import com.alibaba.fastjson.JSON;
import com.sky.model.User_4172;
import com.sky.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/v1/shiyan2")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value="/showUser",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getAllUsers(){
        List<User_4172> allUsers = userService.getAllUsers();
        String json = JSON.toJSONString(allUsers);
        return json;
    }

    @RequestMapping(value="/selectUserById",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String selectUserById(HttpServletResponse response, Integer id){
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        List<User_4172> allUsers = userService.getAllUsers();
        if (id == null || id==0 ){
            String json = JSON.toJSONString(allUsers);
            return json;

        }else {
            User_4172 user_4172 = null;
            for (User_4172 temp:allUsers){
                if (temp.getId().equals(id)){
                    user_4172 = temp;
                }
            }
            String json = JSON.toJSONString(user_4172);
            return json;
        }
    }


    @RequestMapping(value="/insertUser")
    @ResponseBody
    public String insertUser(@RequestBody User_4172 user){

        if (user == null || StringUtils.isEmpty(user.getName()) || user.getAge() == 0 || user.getAge().equals(null) || StringUtils.isEmpty(user.getSex())){
            return JSON.toJSONString("请填写完整信息！");
        }else {
            int i = userService.insertUser(user);
            if (i>0){
                List<User_4172> allUsers = userService.getAllUsers();
                return JSON.toJSONString(allUsers);
            }else {
                return JSON.toJSONString("添加失败！");
            }
        }
        // return "redirect:showUser";
    }


    @RequestMapping(value = "deleteUserById")
    @ResponseBody
    public String deleteUserById(@RequestBody String id){
        //System.out.println(id.substring(6,id.length()-1));
        int i = userService.deleteUserById(id.substring(6,id.length()-1));
        if (i>0){
            List<User_4172> allUsers = userService.getAllUsers();
            return JSON.toJSONString(allUsers);
        }
        return JSON.toJSONString("");
    }

    @RequestMapping(value = "updateUserById")
    @ResponseBody
    public String updateUserById(@RequestBody User_4172 user){
        int i = userService.updateUserById(user);
        if (i>0){
            List<User_4172> allUsers = userService.getAllUsers();
            return JSON.toJSONString(allUsers);
        }
        return JSON.toJSONString("");
    }



    @RequestMapping("/addPage")
    public String addPage(){
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User_4172 user,Model model){
        if (user == null || StringUtils.isEmpty(user.getName()) || user.getAge() == 0 || user.getAge().equals(null) || StringUtils.isEmpty(user.getSex())){
            model.addAttribute("state","请填写完整信息！");
        }else {
            int i = userService.insertUser(user);
            if (i>0){
                model.addAttribute("state","添加成功！");
            }else {
                model.addAttribute("state","添加失败！");
            }
        }
        // return "redirect:showUser";
        List<User_4172> allUsers = userService.getAllUsers();
        model.addAttribute("users",allUsers);
        return "showUser";
    }
}
