package cn.vonfly.interfaces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/say")
    public @ResponseBody String sayHello(){
        return System.currentTimeMillis()+"- hello";
    }
}
