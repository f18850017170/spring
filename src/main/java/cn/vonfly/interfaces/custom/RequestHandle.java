package cn.vonfly.interfaces.custom;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface RequestHandle<Req, Resp> {
    @ResponseBody
    public Resp execute(@RequestBody Req req, HttpServletRequest httpServletRequest);
}
