package com.wewe.aspect;

import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: fei2
 * Date:  18-9-13 上午11:44
 * 鉴权参考：
 * https://www.jianshu.com/p/5e37c63a1f5f
 * Description: 请求切面
 * Refer To:
 */

@Aspect
@Component
@Order(5)
public class WebLogAspect {

    private static Logger log = Logger.getLogger("mongodb");

    @Pointcut("execution(public * com.wewe.controller..*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取要记录的日志内容
        // BasicDBObject logInfo = getBasicDBObject(request, joinPoint);
        // log.info(logInfo);
        getNameAndValue(point);
        Method method = ((MethodSignature)point.getSignature()).getMethod();

        if(true){
            return "error message return";
        }
        return point.proceed();
    }

    private BasicDBObject getBasicDBObject(HttpServletRequest request, ProceedingJoinPoint joinPoint) {
        // 基本信息
        BasicDBObject r = new BasicDBObject();
        r.append("requestURL", request.getRequestURL().toString());
        r.append("requestURI", request.getRequestURI());
        r.append("queryString", request.getQueryString());
        r.append("remoteAddr", request.getRemoteAddr());
        r.append("remoteHost", request.getRemoteHost());
        r.append("remotePort", request.getRemotePort());
        r.append("localAddr", request.getLocalAddr());
        r.append("localName", request.getLocalName());
        r.append("method", request.getMethod());
        r.append("headers", getHeadersInfo(request));
        r.append("parameters", request.getParameterMap());
        r.append("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        r.append("args", Arrays.toString(joinPoint.getArgs()));
        // 获取 参数名称、类型、值
        r.append("nameAndValue:",getNameAndValue(joinPoint));
        return r;
    }
    /**
     * 获取参数Map集合
     * @param joinPoint
     * @return
     */
    Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>();
        // 获取参数值
        Object[] paramValues = joinPoint.getArgs();
        // 获取参数名称
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        // 获取参数类型
        Class[] paramTypes = ((CodeSignature)joinPoint.getSignature()).getParameterTypes();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        return param;
    }


    /**
     * 获取头信息
     *
     * @param request
     * @return
     */
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

}
