/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/6/1 11:09:03                            */
/*==============================================================*/


drop table if exists File_Attach;

drop table if exists Food;

drop table if exists Food_Activity;

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
/* Table: Food_Activity                                         */
/*==============================================================*/
create table Food_Activity
(
   ID                   int not null auto_increment,
   UserID               int,
   FileID               int,
   Title                varchar(100),
   Location             varchar(100),
   StartDate            datetime,
   EndDate              datetime,
   DetailLocation       varchar(100),
   Description          text,
   primary key (ID)
);

alter table Food_Activity comment '美食活动表';

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
   ID                   int not null,
   Username             varchar(100) not null,
   Password             varchar(100) not null,
   Salt                 varchar(100) not null,
   Remark               varchar(200),
   primary key (ID)
);

alter table System_User comment '系统用户表';

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

alter table Food add constraint FK_P_FileAttach_C_Food_FileID foreign key (FileID)
      references File_Attach (ID) on delete restrict on update restrict;

alter table Food add constraint FK_P_SystemUser_C_Food_UserID foreign key (UserID)
      references System_User (ID) on delete restrict on update restrict;

alter table Food_Activity add constraint FK_P_FileAttach_C_FoodActivity_FileID foreign key (FileID)
      references File_Attach (ID) on delete restrict on update restrict;

alter table Food_Activity add constraint FK_P_SystemUser_C_FoodActivity_UserID foreign key (UserID)
      references System_User (ID) on delete restrict on update restrict;

alter table Food_Step add constraint FK_P_FileAttach_C_FoodStep_FileID foreign key (FileID)
      references File_Attach (ID) on delete restrict on update restrict;

alter table food_collect add constraint FK_P_Food_C_FoodCollect_FoodID foreign key (FoodID)
      references Food (ID) on delete restrict on update restrict;

alter table food_collect add constraint FK_P_SystemUser_C_FoodCollect_UserID foreign key (UserID)
      references System_User (ID) on delete restrict on update restrict;

