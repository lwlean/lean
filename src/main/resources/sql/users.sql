CREATE SEQUENCE user_id_seq START WITH 1 INCREMENT BY 1 MINVALUE 1 NO MAXVALUE;

CREATE TABLE "public"."users" (
  "id" int8 DEFAULT nextval('user_id_seq'::regclass) NOT NULL,
  "name" varchar(255),
  "password" varchar(255),
  "age" int4,
  "introduction" varchar(255)
)

CREATE SEQUENCE expenses_id_seq START WITH 1 INCREMENT BY 1 MINVALUE 1 NO MAXVALUE;

CREATE TABLE "public"."expenses" (
  "id" int8 DEFAULT nextval('expenses_id_seq'::regclass) NOT NULL,
  "amount" numeric,
  "type" varchar(255),
  "time" timestamp,
  "current_time" timestamp,
  "content" varchar(255)
)