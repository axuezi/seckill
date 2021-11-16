package com.axue.core.base;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
public class BaseEntity implements Serializable {

    /**
     * 雪花算法
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("ID")
    private String id;

    /**
     * 版本（用于乐观锁，后期考虑）
     */
    @Version
    @ApiModelProperty("版本")
    private Long version;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 创建人ID
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建人ID")
    private String createBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    /**
     * 修改人ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("修改人ID")
    private String updateBy;

    /**
     * 是否删除：0-未删除；1-已删除
     */
    @TableLogic
    private Integer logicDel;

}