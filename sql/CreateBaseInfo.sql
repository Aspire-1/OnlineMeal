-- 用户信息表
create table USER_INFO(
  USER_ID NUMBER(10) primary key,
  
  USER_REGIST_PHONE VARCHAR(11),
  USER_REGIST_EMAIL VARCHAR(50),
  USER_REGIST_CODE VARCHAR(10),
  USER_REGIST_CODE_TIME TIMESTAMP ,
  USER_REGIST_TIME TIMESTAMP,
  USER_LAST_LOGIN_TIME  TIMESTAMP,
  USER_USER_NAME VARCHAR(100),    --新增字段，未更新 2018-3-11
  USER_PASSWORD VARCHAR(500),
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

--用户地址表
create table USER_ADDRESS_INFO(
  USER_ADDRESS_ID NUMBER(10) primary key,
  
  USER_ADDRESS_USERID NUMBER(10),  --关联用户主键
  USER_ADDRESS_ADDRESS VARCHAR(200),
  USER_ADDRESS_IS_DEFAULT VARCHAR(5) default 'N'
);

comment on column USER_ADDRESS_INFO.USER_ADDRESS_USERID is '用户地址表关联的用户主键';
comment on column USER_ADDRESS_INFO.USER_ADDRESS_IS_DEFAULT is '是否为用户的默认地址';

drop table USER_ADDRESS_INFO

create sequence seq_user_address 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

--用户订单信息表
create table USER_ORDER_INFO(
  USER_ORDER_ID NUMBER(10) primary key,
  
  USER_ORDER_MARCHANT_ID NUMBER(10),  --用户订单商家主键
  USER_ORDER_MARCHANT_NAME VARCHAR(50),  --用户订单商家名称
  USER_ORDER_MARCHANT_STATE VARCHAR(5),  --用户订单商家状态 （枚举值看用户商家表）
  
  USER_ORDER_CODE VARCHAR(30),  --用户订单编号 生成给用户看的标志 格式：用户ID(格式化四位)+商家ID(格式化四位)+序号五位（自增）
  USER_ORDER_USERID NUMBER(10),  --用户id
  USER_ORDER_USERNAME VARCHAR(100),  --用户名
  USER_ORDER_USERPHONE VARCHAR(11),  --用户联系方式
  
  USER_ORDER_IS_TO_RESTAURANT VARCHAR(5), --用户是否到店就餐 Y 是 N 否
  
  USER_ORDER_MEMBER NUMBER(4), --到店就餐人数
  USER_ORDER_RESERVE_TIME TIMESTAMP,  --预约时间
  
  USER_ORDER_SEND_ADDRESS VARCHAR(200),  --送餐地址
  
  USER_ORDER_CREATE_TIME TIMESTAMP,  --用户下单时间  插入记录时间
  USER_ORDER_STATE VARCHAR(5) default '02',  --用户订单状态 01 完成订单 02 待商家接单 03 商家已接单 04 烹饪中 05 配送中 06 待取消订单 07 取消订单 99 异常
  
  USER_ORDER_PAY_TYPE VARCHAR(5),  --用户订单付款类型 01 到店支付 02 网上支付
  USER_ORDER_PAY_STATE VARCHAR(5), --用户订单付款状态 01 已付款 02 未付款
  
  USER_ORDER_PRODUCT_COUNT VARCHAR(5),  --用户订单商品数量
  USER_ORDER_OFFEST_PRICE NUMBER(18,2),  --用户订单抵扣金额
  USER_ORDER_TOTAL_PRICE NUMBER(18,2),  --用户订单总额
  USER_ORDER_PAY_PRICE NUMBER(18,2),  --用户订单应付款
  
  USER_ORDER_NOTE VARCHAR(500)  -- 用户订单备注
  
  -- USER_ORDER_ORDERID NUMBER(10)  用户订单信息表关联订单信息  无效字段
);

drop table USER_ORDER_INFO

create sequence seq_user_order_info 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

-- 订单信息表
create table ORDER_INFO(
  ORDER_ID NUMBER(10) primary key,
  
  ORDER_USER_ORDER_ID NUMBER(10),  --关联用户订单的主键
  
  ORDER_DISHED_ID VARCHAR(10),  -- 关联菜肴信息表中的菜肴的主键  --未更改 该值类型应该为NUMBER 2018-3-15
  ORDER_DISHED_NAME VARCHAR(20),  --菜肴名称
  ORDER_DISHED_COUNT NUMBER(5),  --菜肴数量
  ORDER_DISHED_PRICE NUMBER(18,2),  --菜肴原价格
  ORDER_DISHED_DISCOUNT NUMBER(18,2),  --菜肴折扣
  ORDER_DISHED_DISCOUNT_PRICE NUMBER(18,2)  --菜肴折后价
);

drop table ORDER_INFO

create sequence seq_order_info 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;
