package com.chc.seckill.config;

import com.chc.seckill.constant.UserConstant;
import com.chc.seckill.modal.entity.User;
import com.chc.seckill.service.UserService;
import com.chc.seckill.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 *@title UserArgumentResolver
 *@description <TODO description class purpose>
 *@author chc
 *@version 1.0.0
 *@create 2023/3/21 10:08
 **/
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private UserService userService;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> parameterType = parameter.getParameterType();
        return parameterType == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        String cookie = CookieUtil.getCookieValue(request,UserConstant.USER_LOGIN_COOKIE);
        if(StringUtils.isEmpty(cookie)){
            return null;
        }
        return userService.getCurrentUser(cookie,request,response);
    }
}
