use saas_auth_user;

-- auto-generated definition
DROP TABLE IF EXISTS `t_user_info`;
create table t_user_info
(
    id          bigint               not null comment 'ID'
        primary key,
    name        varchar(64)          null comment '用户姓名',
    price       decimal(10, 2)       null comment '余额',
    create_time datetime             null comment '创建时间',
    create_by   varchar(64)          null comment '创建人',
    update_time datetime             null comment '修改时间',
    update_by   varchar(64)          null comment '修改人',
    logic_del   tinyint(1) default 0 null comment '0:正常,1:已删除'
)
    comment '用户表' charset = utf8mb4;