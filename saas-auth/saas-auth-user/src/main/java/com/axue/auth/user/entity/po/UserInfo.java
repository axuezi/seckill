package com.axue.auth.user.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.axue.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user_info")
@ApiModel(value="UserInfo对象", description="用户表")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "余额")
    private BigDecimal price;


}
