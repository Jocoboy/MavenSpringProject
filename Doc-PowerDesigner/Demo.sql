/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/5/19 22:23:51                           */
/*==============================================================*/


drop table if exists File_Attach;

drop table if exists Food;

drop table if exists Food_Step;

drop table if exists System_User;

drop table if exists food_collect;

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
   UserID               int,
   FileID               int,
   FoodName             varchar(100),
   DeployDate           datetime,
   FoodMaterial         text,
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
   FoodID               int,
   FileID               int,
   StepNo               int,
   StepDesc             text,
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

/*==============================================================*/
/* Table: food_collect                                          */
/*==============================================================*/
create table food_collect
(
   ID                   int not null auto_increment,
   UserID               int,
   FoodID               int,
   Star                 bool,
   primary key (ID)
);

alter table food_collect comment '美食收藏表';

alter table Food add constraint FK_Reference_3 foreign key (UserID)
      references System_User (ID) on delete restrict on update restrict;

alter table Food add constraint FK_Reference_4 foreign key (FileID)
      references File_Attach (ID) on delete restrict on update restrict;

alter table Food_Step add constraint FK_Reference_5 foreign key (FoodID)
      references Food (ID) on delete restrict on update restrict;

alter table Food_Step add constraint FK_Reference_6 foreign key (FileID)
      references File_Attach (ID) on delete restrict on update restrict;

alter table food_collect add constraint FK_Reference_7 foreign key (UserID)
      references System_User (ID) on delete restrict on update restrict;

alter table food_collect add constraint FK_Reference_8 foreign key (FoodID)
      references Food (ID) on delete restrict on update restrict;

