USE `saas_solution_product`;

-- auto-generated definition
DROP TABLE IF EXISTS `t_product_info`;
create table t_product_info
(
    id          bigint               not null comment 'ID'
        primary key,
    name        varchar(64)          null comment '商品名称',
    title       text                 null comment '商品标题',
    price       decimal(10, 2)       null comment '商品价格',
    remarks     text                 null comment '商品描述',
    create_time datetime             null comment '创建时间',
    create_by   varchar(64)          null comment '创建人',
    update_time datetime             null comment '修改时间',
    update_by   varchar(64)          null comment '修改人',
    logic_del   tinyint(1) default 0 null comment '0:正常,1:已删除'
)
    comment '商品表' charset = utf8mb4;

