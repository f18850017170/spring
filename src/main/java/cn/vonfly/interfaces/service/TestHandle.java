package cn.vonfly.interfaces.service;

import cn.vonfly.interfaces.custom.RequestHandle;
import cn.vonfly.interfaces.custom.annotation.ApiGateWay;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/5.
 */
@ApiGateWay("/test/hello")
public class TestHandle implements RequestHandle<String, String> {

    public String execute(@RequestBody String s, HttpServletRequest httpServletRequest) {
        return "test" + System.currentTimeMillis();
    }
}
