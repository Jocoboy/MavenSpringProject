/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/5/17 15:14:13                           */
/*==============================================================*/


drop table if exists File_Attach;

drop table if exists Food;

drop table if exists Food_Step;

drop table if exists System_User;

/*==============================================================*/
/* Table: File_Attach                                           */
/*==============================================================*/
create table File_Attach
(
   ID                   int not null auto_increment,
   FileName             varchar(200),
   FilePath             varchar(200),
   Ext                  varchar(200),
   FileType             varchar(200),
   Note                 varchar(200),
   primary key (ID)
);

alter table File_Attach comment '附件表';

/*==============================================================*/
/* Table: Food                                                  */
/*==============================================================*/
create table Food
(
   ID                   int not null auto_increment,
   User_ID              int,
   File_ID              int,
   Food_Name            varchar(100),
   Deploy_Date          datetime,
   Food_Material        text,
   Steps                int,
   Likes                int,
   primary key (ID)
);

alter table Food comment '美食主信息表';

/*==============================================================*/
/* Table: Food_Step                                             */
/*==============================================================*/
create table Food_Step
(
   ID                   int not null auto_increment,
   Food_ID              int,
   File_ID              int,
   Step_No              int,
   Step_Desc            text,
   primary key (ID)
);

alter table Food_Step comment '美食制作分步信息表';

/*==============================================================*/
/* Table: System_User                                           */
/*==============================================================*/
create table System_User
(
   ID                   int not null auto_increment,
   Username             varchar(100) not null,
   Password             varchar(100) not null,
   Salt                 varchar(100) not null,
   Remark               varchar(200),
   primary key (ID)
);

alter table System_User comment '系统用户表1';

alter table Food add constraint FK_Reference_3 foreign key (User_ID)
      references System_User (ID) on delete restrict on update restrict;

alter table Food add constraint FK_Reference_4 foreign key (File_ID)
      references File_Attach (ID) on delete restrict on update restrict;

alter table Food_Step add constraint FK_Reference_5 foreign key (Food_ID)
      references Food (ID) on delete restrict on update restrict;

alter table Food_Step add constraint FK_Reference_6 foreign key (File_ID)
      references File_Attach (ID) on delete restrict on update restrict;

