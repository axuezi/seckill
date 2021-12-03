USE `saas_solution_stock`;

-- auto-generated definition
DROP TABLE IF EXISTS `t_stock_info`;
create table t_stock_info
(
    id           bigint               not null comment 'ID'
        primary key,
    product_id   bigint               null comment '商品ID',
    product_name varchar(64)          null comment '商品名称',
    activity_id  bigint               null comment '活动ID',
    total_num    bigint               null comment '总库存数量',
    lock_num     bigint               null comment '锁定库存数量',
    create_time  datetime             null comment '创建时间',
    create_by    varchar(64)          null comment '创建人',
    update_time  datetime             null comment '修改时间',
    update_by    varchar(64)          null comment '修改人',
    logic_del    tinyint(1) default 0 null comment '0:正常,1:已删除'
)
    comment '库存表' charset = utf8mb4;

