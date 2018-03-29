alter table USER_INFO add (USER_OPENID VARCHAR(50));

comment on column USER_INFO.USER_OPENID is '微信唯一标识';
