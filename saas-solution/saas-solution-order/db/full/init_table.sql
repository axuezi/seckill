USE `saas_solution_order`;

-- auto-generated definition
DROP TABLE IF EXISTS `t_order_info`;
create table t_order_info
(
    id          bigint               not null comment 'ID'
        primary key,
    order_code  varchar(64)          null comment '订单编码',
    product_id  bigint               null comment '商品ID',
    user_code   varchar(64)          null comment '用户编码',
    order_price decimal(10, 2)       null comment '订单金额',
    buy_num     int                  null comment '购买数量',
    create_time datetime             null comment '创建时间',
    create_by   varchar(64)          null comment '创建人',
    update_time datetime             null comment '修改时间',
    update_by   varchar(64)          null comment '修改人',
    logic_del   tinyint(1) default 0 null comment '0:正常,1:已删除'
)
    comment '订单表' charset = utf8mb4;
