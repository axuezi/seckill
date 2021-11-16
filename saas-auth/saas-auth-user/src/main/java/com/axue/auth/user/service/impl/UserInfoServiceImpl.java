package com.axue.auth.user.service.impl;

import com.axue.auth.user.entity.po.UserInfo;
import com.axue.auth.user.mapper.UserInfoMapper;
import com.axue.auth.user.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
