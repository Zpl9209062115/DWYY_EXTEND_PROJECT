package com.nanrui.dwyy.controller;

import com.nanrui.dwyy.service.BDZ_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class BDZ_Controller {

    @Autowired
    BDZ_Service bdz_service;

    @ResponseBody
    @RequestMapping(value = "/bdz",method = RequestMethod.POST)
    public Map<String,Object> testController(@RequestBody Map<String,Object> params, Model model) throws Exception {
        /**
         * {"cityname":"gansu","condition":"1000"}
         */
        String cityname = (String) params.get("cityname");
        String condition = (String) params.get("condition");
        Map<String,Object> htmlMap = bdz_service.readSourceData(cityname,condition);
        if (null != htmlMap){
            return htmlMap;
        } else {
            return null;
        }
    }

    @RequestMapping("/city")
    public String cityDispose(@RequestParam("cityname") String cityname){

        switch (cityname){
            case "内蒙古" :
                return "new_file2_内蒙古.html";
            case "安徽" :
                return "new_file2_安徽.html";
            case "甘肃" :
                return "new_file2_甘肃.html";
            default:
                return "success";
        }
    }

}
