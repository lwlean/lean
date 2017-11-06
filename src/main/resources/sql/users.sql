CREATE SEQUENCE user_id_seq START WITH 1 INCREMENT BY 1 MINVALUE 1 NO MAXVALUE;

CREATE TABLE "public"."users" (
  "id" int8 DEFAULT nextval('user_id_seq'::regclass) NOT NULL,
  "name" varchar(255),
  "password" varchar(255),
  "age" int4,
  "introduction" varchar(255)
)