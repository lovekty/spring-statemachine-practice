create table order_info
(
    id             bigint unsigned auto_increment comment '自增主键，订单id'
        primary key,
    order_spu_info varchar(256)                        not null comment 'spu信息',
    order_sku_info varchar(256)                        not null comment 'sku信息',
    order_state    int                                 not null comment '订单状态',
    order_type     int                                 not null comment '订单类型',
    add_time       timestamp default CURRENT_TIMESTAMP not null comment '添加时间',
    update_time    timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_visible     tinyint(1) default 1 not null comment '软删标志'
) comment 'order info table for ssm demo' collate = utf8mb4_unicode_ci;

