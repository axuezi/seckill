package com.axue.solution.product.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.axue.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_product_info")
@ApiModel(value="ProductInfo对象", description="商品表")
public class ProductInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品标题")
    private String title;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品描述")
    private String remarks;


}
