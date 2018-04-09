alter table USER_INFO add (USER_OPENID VARCHAR(50));

comment on column USER_INFO.USER_OPENID is '微信唯一标识';

alter table USER_INFO ADD (USER_HEAD_PHOTO_URL VARCHAR(200));

comment on column USER_INFO.USER_HEAD_PHOTO_URL is '用户头像路径';
