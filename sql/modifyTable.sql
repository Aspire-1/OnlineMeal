alter table USER_INFO add (USER_OPENID VARCHAR(50));

comment on column USER_INFO.USER_OPENID is '΢��Ψһ��ʶ';

alter table USER_INFO ADD (USER_HEAD_PHOTO_URL VARCHAR(200));

comment on column USER_INFO.USER_HEAD_PHOTO_URL is '�û�ͷ��·��';
