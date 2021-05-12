/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/5/12 15:07:20                           */
/*==============================================================*/


drop table if exists System_User;

/*==============================================================*/
/* Table: System_User                                           */
/*==============================================================*/
create table System_User
(
   ID                   int not null auto_increment,
   Userrname            varchar(100) not null,
   Password             varchar(100) not null,
   Salt                 varchar(100) not null,
   Remark               varchar(200),
   primary key (ID)
);

alter table System_User comment '系统用户表1';

