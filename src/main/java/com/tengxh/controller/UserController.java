package com.tengxh.controller;

import com.tengxh.entity.DataInfo;
import com.tengxh.entity.User;
import com.tengxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    public UserService userInfoService;

//    @RequestMapping("/")
//    public ModelAndView getIndex() {
//
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("list", dataSourceService.selectDataSource());
//        return mav;
//    }
//
//    @RequestMapping("addSource")
//    public ModelAndView addSource() {
//        return new ModelAndView("addSource");
//    }
//
//    @ResponseBody
//    @RequestMapping("addDataSource")
//    public String addDataSource(DataSource dataSource) {
//        Integer result;
//        result = dataSourceService.addDataSource(dataSource);
//        return result.toString();
//    }
//
//    @RequestMapping("editSource")
//    public ModelAndView editSource(int Id) {
//        DataSource dataSource = dataSourceService.getDataSourceById(Id);
//        ModelAndView mv = new ModelAndView("editSource");
//        mv.getModel().put("DataSource", dataSource);
//        return mv;
//    }
//
//    @ResponseBody
//    @RequestMapping("editDataSource")
//    public String editDataSource(DataSource dataSource) {
//        Integer result;
//        result = dataSourceService.updateDataSource(dataSource);
//        return result.toString();
//    }
//
//    @ResponseBody
//    @RequestMapping("deleteDataSource")
//    public String deleteDataSource(int Id) {
//        Integer result;
//        result = dataSourceService.deleteDataSource(Id);
//        return result.toString();
//    }

    @ResponseBody
    @RequestMapping("addUser")
    public String addUser(User user) {
        Integer result;
        result = userInfoService.addUser(user);
        return result.toString();
    }

    @RequestMapping("addUserView")
    public ModelAndView addUserView() {
        return new ModelAndView("addUserView");
    }

    @ResponseBody
    @RequestMapping("deleteUser")
    public String deleteUser(int Id) {
        Integer result;
        result = userInfoService.deleteUser(Id);
        return result.toString();
    }

    @RequestMapping("updateUserView")
    public ModelAndView updateUserView(int Id) {
        User user = userInfoService.getUserById(Id);
        ModelAndView mv = new ModelAndView("updateUserView");
        mv.getModel().put("User", user);
        return mv;
    }

    @ResponseBody
    @RequestMapping("updateUser")
    public String updateUser(User user) {
        Integer result;
        result = userInfoService.updateUser(user);
        return result.toString();
    }

    @RequestMapping("selectUser")
    public ModelAndView selectUser() {
        ModelAndView mav = new ModelAndView("index");
        List<User> list = userInfoService.selectUser();
        mav.addObject("list", list);

        return mav;
    }
}
