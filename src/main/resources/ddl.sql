create table item_info
(
    id               bigint unsigned auto_increment comment '自增主键'
        primary key,
    item_name        varchar(64)                             not null comment '名称',
    item_state       int                                     not null comment '状态',
    item_type        int                                     not null comment '类型',
    item_description varchar(1024) default ''                not null comment '描述',
    add_time         timestamp     default CURRENT_TIMESTAMP not null comment '添加时间',
    update_time      timestamp     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_visible       tinyint(1)    default 1                 not null comment '软删标志'
)
    comment 'demo item table' collate = utf8mb4_unicode_ci;

