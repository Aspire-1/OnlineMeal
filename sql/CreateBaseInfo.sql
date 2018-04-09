-- 用户信息表
create table USER_INFO(
  USER_ID NUMBER(10) primary key,
  
  USER_REGIST_PHONE VARCHAR(11),
  USER_REGIST_EMAIL VARCHAR(50),
  USER_REGIST_CODE VARCHAR(10),
  USER_REGIST_CODE_TIME TIMESTAMP ,
  USER_REGIST_TIME TIMESTAMP,
  USER_LAST_LOGIN_TIME  TIMESTAMP,
  USER_USER_NAME VARCHAR(100),    --新增字段，未更新 2018-3-11 已更新 2018-3-23
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

drop table USER_INFO

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
  
  ORDER_DISHED_ID NUMBER(10),  -- 关联菜肴信息表中的菜肴的主键  --未更改 该值类型应该为NUMBER 2018-3-15   --已更改 2018-3-23
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


--商家信息表
create table MARCHANT_INFO(
  MARCHANT_INFO_ID NUMBER(10) primary key,
  MARCHANT_NAME VARCHAR(30),
  MARCHANT_ADDRESS VARCHAR(100),
  MARCHANT_CONTACT VARCHAR(20),  --商家联系方式
  
  MARCHANT_LONGITUDE VARCHAR(10),  --经度
  MARCHANT_LATITUDE VARCHAR(10),  --纬度
  
  MARCHANT_MANAGER_NAME VARCHAR(20),
  MARCHANT_MANAGER_PHONE VARCHAR(15),  --商户老板电话
  
  MARCHANT_QUALIFIED_AUDUT_ID NUMBER(10),  --关联商家资格审核表主键
  
  MARCHANT_IS_AUDIT VARCHAR(5) default '02', --审核状态 01 审核通过 02 审核中 99 审核未通过
  
  MARCHANT_STATE VARCHAR(5) default '79', --商家状态 01 正常 02 休息中 03 接单中 79 待审批 89 已注销 99 异常 
  
  MARCHANT_REGIST_TIME TIMESTAMP,  --商家注册时间
  MARCHANT_TYPE VARCHAR(10),  -- 商家类型 法 意 中 快...
  MARCHANT_START_TIME TIMESTAMP,  --商家开始营业时间
  MARCHANT_END_TIME TIMESTAMP,  --商家结束营业时间
  
  MARCHANT_TOTAL_SCORE NUMBER(5,2),
  MARCHANT_FOOD_SCORE NUMBER(5,2),
  MARCHANT_SERVICE_SOCRE NUMBER(5,2),
  MARCHANT_ENVIRONMENT_SCORE NUMBER(5,2),
  
  MARCHANT_PHOTO BLOB,		--商家照片 未更新 20180403
  
  MARCHANT_NOTE VARCHAR(500)
);


create sequence seq_marchant_info 
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

--附加 菜肴类型表
create table DISHED_TYPE(
  DISHED_TYPE_ID NUMBER(10) primary key,
  
  DISHED_TYPE_CODE VARCHAR(5),
  DISHED_TYPE_SUBCODE VARCHAR(5),
  
  DISHED_TYPE_NAME VARCHAR(30)
);

create sequence seq_dished_type
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;

create table DISHED_INFO(
 DISHED_INFO_ID NUMBER(10) primary key,
 
 DISHED_MARCHANT_MENUID NUMBER(10),  --菜肴关联菜单的键
 
 DISHED_NAME VARCHAR(30),  --菜肴名称
 
 DISHED_TYPE_CODE VARCHAR(5),  --菜肴类型编号
 DISHED_TYPE_NAME VARCHAR(30),  --菜肴类型名称
 
 DISHED_SPECIFICATION VARCHAR(20),  --菜肴规格 
 DISHED_STORE NUMBER(5),  --剩余菜肴量
 
 DISHED_INTRODUCE VARCHAR(100),  --菜肴介绍
 DISHED_PHOTO blob,  --菜肴图片
 DISHED_PHOTO_SRC VARCHAR(200), --图片地址
 
 DISHED_SCORE NUMBER(5,2),  --菜肴获取分数
 
 DISHED_PRICE NUMBER(18,2),  --菜肴原价
 DISHED_DISCOUNT NUMBER(18,2),  --菜肴折扣
 DISHED_DISCOUNT_PRICE NUMBER(18,2)  --菜肴折后价
 
);

create sequence seq_dished_info
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;


--未执行 2018-04-08--

--商家管理员信息表
create table MARCHANT_MANAGER(
  MARCHANT_MANAGER_ID NUMBER(10) primary key,
  
  MARCHANT_MANAGER_MARCHANTID NUMBER(10),  --管理员关联的商家ID
  
  MARCHANT_MANAGER_USERNAME VARCHAR(30),
  MARCHANT_MANAGER_PHONE VARCHAR(11),   --商家管理员手机号
  MARCHANT_MANAGER_PASSWORD VARHCANT(500),
  
  MARCHANT_MANAGER_LASTLOGIN_TIME TIMESTAMP,  --管理员最后登陆时间
  
  MARCHANT_MANAGER_ROLE VARCHAR(5) default 'S',  -- P表示超级商家管理员一个商户只有一个P管理员 由系统管理员分配  S 表示商家管理员  有P权限管理员分配 一个商户可以有多个S管理员
  
  MARCHANT_MANAGER_STATES VARCHAR(5),  --商家管理员状态，90 正常 99 已注销
  MARCHANT_MANAGER_LOGIN_STATES VARCHAR(5)  --商家管理员登陆状态  01 在线  02 下线
);

create sequence seq_marchant_manager
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;


--商家审核信息表

--商家关系神审核表（审核状态） 商家注册完毕之后 录入审核信息  点击提交审核  --> 审核关系表中

    --审核商家id
    --审核信息id
    --审核状态  --点击通过 自动插入一条商家管理员信息 role为P


-- 后台管理员
create table SYS_MANAGER(
  SYS_MANAGER_ID NUMBER(10),  --系统管理员主键
  
  SYS_MANAGER_USERNAME VARCHAR(30),  --系统管理员用户名
  SYS_MANAGER_PASSWORD VARCHAR(500),  --系统管理员密码
  
  SYS_MANAGER_LASTLOGIN_TIME TIMESTAMP,  --系统管理员最后登陆时间
  SYS_MANAGER_LOGIN_STATUS VARCHAR(5),  --系统管理员登陆状态  01 在线 02 下线
);

create sequence seq_sys_manager
increment by 1 
start with 1
maxvalue 999999
nocycle nocache;