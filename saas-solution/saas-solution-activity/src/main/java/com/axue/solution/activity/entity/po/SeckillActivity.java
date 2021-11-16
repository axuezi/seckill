package com.axue.solution.activity.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.axue.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 秒杀活动
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_seckill_activity")
@ApiModel(value="SeckillActivity对象", description="秒杀活动")
public class SeckillActivity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动名称")
    private String name;

    @ApiModelProperty(value = "活动类型")
    private Boolean nameType;

    @ApiModelProperty(value = "商品Id")
    private String productId;

    @ApiModelProperty(value = "活动价格")
    private BigDecimal price;

    @ApiModelProperty(value = "活动数量")
    private Integer num;


}
