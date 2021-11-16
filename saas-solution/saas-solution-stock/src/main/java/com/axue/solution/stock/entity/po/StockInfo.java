package com.axue.solution.stock.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.axue.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 库存表
 * </p>
 *
 * @author axue
 * @since 2021-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_stock_info")
@ApiModel(value="StockInfo对象", description="库存表")
public class StockInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    private Long productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "活动ID")
    private Long activityId;

    @ApiModelProperty(value = "总库存数量")
    private Long totalNum;

    @ApiModelProperty(value = "锁定库存数量")
    private Long lockNum;


}
