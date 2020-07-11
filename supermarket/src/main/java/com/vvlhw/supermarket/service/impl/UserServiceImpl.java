package com.vvlhw.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vvlhw.supermarket.dto.OrderDTO;
import com.vvlhw.supermarket.entity.User;
import com.vvlhw.supermarket.dao.UserMapper;
import com.vvlhw.supermarket.enums.ResultEnum;
import com.vvlhw.supermarket.exception.MarketException;
import com.vvlhw.supermarket.handler.MyLocalDateTimeTypeHandler;
import com.vvlhw.supermarket.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vvlhw.supermarket.utils.*;
import com.vvlhw.supermarket.vo.RegisterVO;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 梁汉伟
 * @since 2020-07-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 发送短信
    public void sendMessage(String userPhone)
    {
        // 查询用户手机号码是否已注册
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_phone", userPhone);
        User u = this.baseMapper.selectOne(wrapper);
        if(!StringUtils.isEmpty(u))
            throw new MarketException(ResultEnum.ALREADY_REGISTER);

        // 如果数据库中已存在验证码信息
        String code = redisTemplate.opsForValue().get(userPhone);
        if(!StringUtils.isEmpty(code))
            throw new MarketException(ResultEnum.CODE_ALREADY_EXIST);
        code = KeyUtil.getMsgCode();

        // 发送短信失败
        if(!SendMsgUtil.sendMsg(userPhone, code))
            throw new MarketException(ResultEnum.SEND_CODE_FAIL);

        // 将手机作为key，code作为value存到redis中，有效期为5分钟
        redisTemplate.opsForValue().set(userPhone, code, 5, TimeUnit.MINUTES);
    }


    // 校验验证码
    public void checkCode(Map<String, String> map) {
        String userPhone = map.get("userPhone");
        String sendCode = map.get("code");

        // 如果用户没有填写手机号或验证码
        if(userPhone == null || sendCode == null)
            throw new MarketException(ResultEnum.PARAM_ERROR);

        String code = redisTemplate.opsForValue().get(userPhone);
        // 验证码匹配失败
        if(!code.equals(sendCode))
            throw new MarketException(ResultEnum.CODE_ERROR);
    }



    public void register(RegisterVO registerVO)
    {
        User user = new User();
        BeanUtils.copyProperties(registerVO, user);
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("user_phone", user.getUserPhone());
//        User u = this.baseMapper.selectOne(wrapper);
//        if(!StringUtils.isEmpty(u))
//            throw new MarketException(ResultEnum.ALREADY_REGISTER);
        String salt = SaltUtil.getSalt();
        user.setUserSalt(salt);
        String inputPassword = user.getUserPassword();
        String savePassword = Md5Util.code(inputPassword + salt);
        user.setUserPassword(savePassword);
        save(user);
    }






//    @Result(column="createTime", property="createTime",javaType = LocalDateTime.class,
//            jdbcType = JdbcType.DATE,typeHandler = MyLocalDateTimeTypeHandler.class)
//    @Result(column="updateTime", property="updateTime",javaType = LocalDateTime.class,
//            jdbcType = JdbcType.DATE,typeHandler = MyLocalDateTimeTypeHandler.class)
    public User checkUser(String userPhone, String password)
    {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_phone", userPhone);
        User user = this.baseMapper.selectOne(wrapper);



        if(StringUtils.isEmpty(user))
            throw new MarketException(ResultEnum.USER_NOT_FOUND);
        String savePassword = user.getUserPassword();
        String inputPassword = Md5Util.code(password + user.getUserSalt());
        if(!savePassword.equals(inputPassword))
            throw new MarketException(ResultEnum.PASSWORD_ERROR);
        user.setUserPassword(null);
        user.setUserSalt(null);
        return user;
    }
    
    // 修改用户信息
    public void updateUser(User user)
    {

        String salt = SaltUtil.getSalt();
        user.setUserSalt(salt);
        String inputPassword = user.getUserPassword();
        String savePassword = Md5Util.code(inputPassword + salt);
        user.setUserPassword(savePassword);
        this.baseMapper.updateById(user);
    }


    // 获取用户订单信息
    public OrderDTO findUserOrders(Long id)
    {
        return this.baseMapper.findOrderById(id);
    }


}
