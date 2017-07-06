package cn.vonfly.interfaces.custom;

import cn.vonfly.interfaces.custom.annotation.ApiGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
public class MyRequestMappingHandlerMapping extends RequestMappingHandlerMapping{
    @Autowired
    private List<RequestHandle> handles;
    @Override
    protected void initHandlerMethods() {
        super.initHandlerMethods();
        //do something for you
        Method method = RequestHandle.class.getDeclaredMethods()[0];
        for (RequestHandle handle : handles) {
            ApiGateWay annotation = handle.getClass().getAnnotation(ApiGateWay.class);
            if (null != annotation){
                String value = annotation.value();
                if (null != value && value.length()>0){//other validate
                    Method[] declaredMethods = handle.getClass().getDeclaredMethods();
                    for (Method declaredMethod : declaredMethods) {
                        if (declaredMethod.isBridge() && method.getName().equals(declaredMethod.getName())){
                            super.registerHandlerMethod(handle,declaredMethod,build(value));
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * build RequestMappingInfo
     * @param mapping
     * @return
     */
    private RequestMappingInfo build(final String mapping){
        RequestMapping requestMapping = new RequestMapping() {
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            public String name() {
                return null;
            }

            public String[] value() {
                return new String[]{mapping};
            }

            public String[] path() {
                return new String[]{mapping};
            }

            public RequestMethod[] method() {
                return new RequestMethod[0];
            }

            public String[] params() {
                return new String[0];
            }

            public String[] headers() {
                return new String[0];
            }

            public String[] consumes() {
                return new String[0];
            }

            public String[] produces() {
                return new String[0];
            }
        };
        return super.createRequestMappingInfo(requestMapping,null);
    }
}
