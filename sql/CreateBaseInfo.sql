-- �û���Ϣ��
create table USER_INFO(
  USER_ID NUMBER(10) primary key,
  
  USER_REGIST_PHONE VARCHAR(11),
  USER_REGIST_EMAIL VARCHAR(50),
  USER_REGIST_CODE VARCHAR(10),
  USER_REGIST_CODE_TIME TIMESTAMP ,
  USER_REGIST_TIME TIMESTAMP,
  USER_LAST_LOGIN_TIME  TIMESTAMP,
  USER_USER_NAME VARCHAR(100),    --�����ֶΣ�δ���� 2018-3-11
  USER_PASSWORD VARCHAR(500),
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

--�û���ַ��
create table USER_ADDRESS_INFO(
  USER_ADDRESS_ID NUMBER(10) primary key,
  
  USER_ADDRESS_USERID NUMBER(10),  --�����û�����
  USER_ADDRESS_ADDRESS VARCHAR(200),
  USER_ADDRESS_IS_DEFAULT VARCHAR(5) default 'N'
);

comment on column USER_ADDRESS_INFO.USER_ADDRESS_USERID is '�û���ַ��������û�����';
comment on column USER_ADDRESS_INFO.USER_ADDRESS_IS_DEFAULT is '�Ƿ�Ϊ�û���Ĭ�ϵ�ַ';

drop table USER_ADDRESS_INFO

create sequence seq_user_address 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

--�û�������Ϣ��
create table USER_ORDER_INFO(
  USER_ORDER_ID NUMBER(10) primary key,
  
  USER_ORDER_MARCHANT_ID NUMBER(10),  --�û������̼�����
  USER_ORDER_MARCHANT_NAME VARCHAR(50),  --�û������̼�����
  USER_ORDER_MARCHANT_STATE VARCHAR(5),  --�û������̼�״̬ ��ö��ֵ���û��̼ұ�
  
  USER_ORDER_CODE VARCHAR(30),  --�û�������� ���ɸ��û����ı�־ ��ʽ���û�ID(��ʽ����λ)+�̼�ID(��ʽ����λ)+�����λ��������
  USER_ORDER_USERID NUMBER(10),  --�û�id
  USER_ORDER_USERNAME VARCHAR(100),  --�û���
  USER_ORDER_USERPHONE VARCHAR(11),  --�û���ϵ��ʽ
  
  USER_ORDER_IS_TO_RESTAURANT VARCHAR(5), --�û��Ƿ񵽵�Ͳ� Y �� N ��
  
  USER_ORDER_MEMBER NUMBER(4), --����Ͳ�����
  USER_ORDER_RESERVE_TIME TIMESTAMP,  --ԤԼʱ��
  
  USER_ORDER_SEND_ADDRESS VARCHAR(200),  --�Ͳ͵�ַ
  
  USER_ORDER_CREATE_TIME TIMESTAMP,  --�û��µ�ʱ��  �����¼ʱ��
  USER_ORDER_STATE VARCHAR(5) default '02',  --�û�����״̬ 01 ��ɶ��� 02 ���̼ҽӵ� 03 �̼��ѽӵ� 04 ����� 05 ������ 06 ��ȡ������ 07 ȡ������ 99 �쳣
  
  USER_ORDER_PAY_TYPE VARCHAR(5),  --�û������������� 01 ����֧�� 02 ����֧��
  USER_ORDER_PAY_STATE VARCHAR(5), --�û���������״̬ 01 �Ѹ��� 02 δ����
  
  USER_ORDER_PRODUCT_COUNT VARCHAR(5),  --�û�������Ʒ����
  USER_ORDER_OFFEST_PRICE NUMBER(18,2),  --�û������ֿ۽��
  USER_ORDER_TOTAL_PRICE NUMBER(18,2),  --�û������ܶ�
  USER_ORDER_PAY_PRICE NUMBER(18,2),  --�û�����Ӧ����
  
  USER_ORDER_NOTE VARCHAR(500)  -- �û�������ע
  
  -- USER_ORDER_ORDERID NUMBER(10)  �û�������Ϣ�����������Ϣ  ��Ч�ֶ�
);

drop table USER_ORDER_INFO

create sequence seq_user_order_info 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

-- ������Ϣ��
create table ORDER_INFO(
  ORDER_ID NUMBER(10) primary key,
  
  ORDER_USER_ORDER_ID NUMBER(10),  --�����û�����������
  
  ORDER_DISHED_ID VARCHAR(10),  -- ����������Ϣ���еĲ��ȵ�����  --δ���� ��ֵ����Ӧ��ΪNUMBER 2018-3-15
  ORDER_DISHED_NAME VARCHAR(20),  --��������
  ORDER_DISHED_COUNT NUMBER(5),  --��������
  ORDER_DISHED_PRICE NUMBER(18,2),  --����ԭ�۸�
  ORDER_DISHED_DISCOUNT NUMBER(18,2),  --�����ۿ�
  ORDER_DISHED_DISCOUNT_PRICE NUMBER(18,2)  --�����ۺ��
);

drop table ORDER_INFO

create sequence seq_order_info 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;
