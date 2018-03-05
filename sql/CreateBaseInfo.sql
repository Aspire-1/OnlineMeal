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
comment on column USER_INFO.USER_REGIST_CODE is '�û�ע����';
comment on column USER_INFO.USER_REGIST_CODE_TIME is '�û�ע������ȡʱ��';
comment on column USER_INFO.USER_LOGIN_STATE is '�û���½״̬ 01 ��½ 02 δ��¼';
comment on column USER_INFO.USER_STATE is '�û�״̬ 01 ���� 02 �쳣 03 ��ע��';
comment on column USER_INFO.USER_IS_DELETE is '�û��Ƿ�ע�� Y �� N ��';
comment on column USER_INFO.USER_HEAD_PHOTO is '�û�ͷ��';

create sequence seq_user_info 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

