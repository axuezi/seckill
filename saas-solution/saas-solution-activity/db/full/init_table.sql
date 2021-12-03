use saas_solution_activity;

DROP TABLE IF EXISTS `t_seckill_activity`;
create table t_seckill_activity
(
    id            bigint               not null comment 'ID'
        primary key,
    name          varchar(64)          null comment '活动名称',
    activity_type tinyint(1) default 0 null comment '活动类型:0:秒杀活动;1:优惠活动',
    product_id    bigint               null comment '商品ID',
    price         decimal(10, 2)       null comment '活动价格',
    num           int(10)              null comment '活动数量',
    create_time   datetime             null comment '创建时间',
    create_by     varchar(64)          null comment '创建人',
    update_time   datetime             null comment '修改时间',
    update_by     varchar(64)          null comment '修改人',
    logic_del     tinyint(1) default 0 null comment '0:正常,1:已删除'
)
    comment '秒杀活动' charset = utf8mb4;