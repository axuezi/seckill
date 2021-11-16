package com.axue.solution.order.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.axue.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_order_info")
@ApiModel(value="OrderInfo对象", description="订单表")
public class OrderInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单编码")
    private String orderId;

    @ApiModelProperty(value = "商品编码")
    private String productId;

    @ApiModelProperty(value = "用户编码")
    private String userId;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "购买数量")
    private Integer buyNum;


}
