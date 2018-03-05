create table USER_INFO(
  USER_ID NUMBER(10) primary key,
  USER_REGIST_PHONE VARCHAR(11),
  USER_REGIST_EMAIL VARCHAR(50),
  USER_REGIST_CODE VARCHAR(10),
  USER_REGIST_CODE_TIME TIMESTAMP ,
  USER_REGIST_TIME TIMESTAMP,
  USER_LAST_LOGIN_TIME  TIMESTAMP,
  USER_PASSWORD VARCHAR(100),
  USER_LOGIN_STATE VARCHAR(5) default '01',
  USER_STATE VARCHAR(5) default '01',
  USER_IS_DELETE VARCHAR(5) default 'N',
  USER_HEAD_PHOTO BLOB,
  USER_ADDRESS VARCHAR(200)
);
comment on column USER_INFO.USER_REGIST_CODE is '用户注册码';
comment on column USER_INFO.USER_REGIST_CODE_TIME is '用户注册码领取时间';
comment on column USER_INFO.USER_LOGIN_STATE is '用户登陆状态 01 登陆 02 未登录';
comment on column USER_INFO.USER_STATE is '用户状态 01 正常 02 异常 03 已注销';
comment on column USER_INFO.USER_IS_DELETE is '用户是否注销 Y 是 N 否';
comment on column USER_INFO.USER_HEAD_PHOTO is '用户头像';

create sequence seq_user_info 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

