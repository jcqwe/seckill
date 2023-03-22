package com.chc.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chc.seckill.modal.entity.User;
import com.chc.seckill.modal.vo.ResponseBean;
import com.chc.seckill.modal.vo.UserLoginVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author Administrator
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2023-03-16 11:53:57
*/
public interface UserService extends IService<User> {

    /**
     * 校验登录参数
     * @param userLoginVo
     * @return
     */
    ResponseBean checkLoginVO(UserLoginVo userLoginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据cookie获取当前登录用户
     * @param cookie
     * @param request
     * @param response
     * @return
     */
    User getCurrentUser(String cookie,HttpServletRequest request, HttpServletResponse response);
}
