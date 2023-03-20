package com.chc.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chc.seckill.constant.UserConstant;
import com.chc.seckill.exception.GlobalException;
import com.chc.seckill.modal.entity.TUser;
import com.chc.seckill.mapper.TUserMapper;
import com.chc.seckill.modal.vo.ResponseBean;
import com.chc.seckill.modal.vo.ResponseEnum;
import com.chc.seckill.modal.vo.UserLoginVo;
import com.chc.seckill.service.TUserService;
import com.chc.seckill.utils.CookieUtil;
import com.chc.seckill.utils.MD5Util;
import com.chc.seckill.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2023-03-16 11:53:57
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
        implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResponseBean checkLoginVO(UserLoginVo userLoginVo, HttpServletRequest request, HttpServletResponse response) {
        //校验参数
        String mobile = userLoginVo.getMobile();
        String password = userLoginVo.getPassword();
        //通过手机号(id)查对应用户
        TUser tUser = tUserMapper.selectById(mobile);
        if (null == tUser) {
            throw new GlobalException(ResponseEnum.LOGIN_ERROR);
        }
        //加密密码对比
        if (!MD5Util.backendPassToDB(password, tUser.getSalt()).equals(tUser.getPassword())) {
            throw new GlobalException(ResponseEnum.LOGIN_ERROR);
        }
        //生成cookie
        String cookie = UUIDUtil.uuid();
//        request.getSession().setAttribute(cookie,tUser);
        //把当前登录用户信息存入redis
        redisTemplate.opsForValue().set("user:" + cookie, tUser);
        CookieUtil.setCookie(request, response, UserConstant.USER_LOGIN_COOKIE, cookie);
        return ResponseBean.success();
    }

    @Override
    public TUser getCurrentUser(String cookie,HttpServletRequest request, HttpServletResponse response) {
        TUser user = (TUser)redisTemplate.opsForValue().get("user:" + cookie);
        if(null != user){
            CookieUtil.setCookie(request, response, UserConstant.USER_LOGIN_COOKIE, cookie);
        }
        return user;
    }
}




