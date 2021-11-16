package com.axue.auth.user.mapper;

import com.axue.auth.user.entity.po.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
