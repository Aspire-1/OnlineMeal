alter table USER_INFO add (USER_OPENID VARCHAR(50));

comment on column USER_INFO.USER_OPENID is '΢��Ψһ��ʶ';

alter table USER_INFO ADD (USER_HEAD_PHOTO_URL VARCHAR(200));

comment on column USER_INFO.USER_HEAD_PHOTO_URL is '�û�ͷ��·��';

--2018-04-11 �Ѹ���
alter table MARCHANT_INFO add (MARCHANT_LOGIN_STATE VARCHAR(5));
comment on column MARCHANT_INFO.MARCHANT_LOGIN_STATE is '�̼ҵ�½״̬';
alter table MARCHANT_INFO add (MARCHANT_PHOTO BLOB);
comment on column MARCHANT_INFO.MARCHANT_PHOTO is '�̼�ͷ��';

--2018-04-12 
alter table DISHED_INFO ADD(DISHED_MARCHANT_ID NUMBER(10));
comment on column DISHED_INFO.DISHED_MARCHANT_ID is '�̼�id'

--2018-04-30
alter table USER_ORDER_INFO ADD(USER_ORDER_TABLE VARCHAR(5));
comment on column USER_ORDER_INFO.USER_ORDER_TABLE is '΢��-����'

alter table MARCHANT_INFO ADD (MARCHANT_PHOTO_URL VARCHAR(200));
comment on column MARCHANT_INFO.MARCHANT_PHOTO_URL is '�̼���Ƭ';