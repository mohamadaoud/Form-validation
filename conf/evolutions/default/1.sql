# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table patients (
  id                        integer not null,
  name                      varchar(255),
  email                     varchar(255),
  constraint pk_patients primary key (id))
;

create sequence patients_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists patients;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists patients_seq;

