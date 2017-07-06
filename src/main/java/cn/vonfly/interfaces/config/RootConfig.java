package cn.vonfly.interfaces.config;

import cn.vonfly.interfaces.custom.MyRequestMappingHandlerMapping;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by Administrator on 2017/7/5.
 */
@Configuration
@ComponentScan(basePackages = {"cn.vonfly"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,
                        value = {EnableWebMvc.class, Controller.class,Configuration.class})}
)
public class RootConfig {
}
