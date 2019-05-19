--------------------------------------------------------
--  File created - Sunday-May-19-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ADDRESSES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CITIZEN_REGISTRATIONS"."ADDRESSES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EDUCATIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CITIZEN_REGISTRATIONS"."EDUCATIONS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PEOPLE_ADDRESSES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PEOPLE_EDUCATIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PEOPLE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CITIZEN_REGISTRATIONS"."PEOPLE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ADDRESSES
--------------------------------------------------------

  CREATE TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" 
   (	"ID" NUMBER, 
	"COUNTRY" VARCHAR2(50 BYTE), 
	"CITY" VARCHAR2(50 BYTE), 
	"MUNICIPALITY" VARCHAR2(50 BYTE), 
	"POSTAL_CODE" VARCHAR2(10 BYTE), 
	"STREET" VARCHAR2(50 BYTE), 
	"NMBR" VARCHAR2(10 BYTE), 
	"FLOOR" NUMBER, 
	"APARTMENTNO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table EDUCATIONS
--------------------------------------------------------

  CREATE TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" 
   (	"ID" NUMBER, 
	"TYPE_ID" NUMBER, 
	"INSTITUTION_NAME" VARCHAR2(50 BYTE), 
	"ENROLLMENT_DATE" DATE, 
	"GRADUATION_DATE" DATE, 
	"GRADUATED" NUMBER(1,0), 
	"FINAL_GRADE" NUMBER(3,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table EDUCATION_TYPE
--------------------------------------------------------

  CREATE TABLE "CITIZEN_REGISTRATIONS"."EDUCATION_TYPE" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GENDER
--------------------------------------------------------

  CREATE TABLE "CITIZEN_REGISTRATIONS"."GENDER" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PEOPLE
--------------------------------------------------------

  CREATE TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" 
   (	"ID" NUMBER, 
	"FIRST_NAME" VARCHAR2(20 BYTE), 
	"MIDDLE_NAME" VARCHAR2(20 BYTE), 
	"LAST_NAME" VARCHAR2(20 BYTE), 
	"GENDER_ID" NUMBER, 
	"HEIGHT" NUMBER, 
	"BIRTH_DATE" DATE, 
	"CURRENT_ADDRESS" NUMBER, 
	"PROFESSION" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PEOPLE_ADDRESSES
--------------------------------------------------------

  CREATE TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" 
   (	"PERSON_ID" NUMBER, 
	"ADDRESS_ID" NUMBER, 
	"ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PEOPLE_EDUCATIONS
--------------------------------------------------------

  CREATE TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" 
   (	"PEOPLE_ID" NUMBER, 
	"EDUCAION_ID" NUMBER, 
	"ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into CITIZEN_REGISTRATIONS.ADDRESSES
SET DEFINE OFF;
Insert into CITIZEN_REGISTRATIONS.ADDRESSES (ID,COUNTRY,CITY,MUNICIPALITY,POSTAL_CODE,STREET,NMBR,FLOOR,APARTMENTNO) values (1,'Bulgaria','Sofia','Sofia','1000','Tsar Boris','15B',null,null);
Insert into CITIZEN_REGISTRATIONS.ADDRESSES (ID,COUNTRY,CITY,MUNICIPALITY,POSTAL_CODE,STREET,NMBR,FLOOR,APARTMENTNO) values (2,'Bulgaria','Sofia','Sofia','1001','Kostenski vodopad','112',null,null);
REM INSERTING into CITIZEN_REGISTRATIONS.EDUCATIONS
SET DEFINE OFF;
REM INSERTING into CITIZEN_REGISTRATIONS.EDUCATION_TYPE
SET DEFINE OFF;
Insert into CITIZEN_REGISTRATIONS.EDUCATION_TYPE (ID,NAME) values (1,'None');
Insert into CITIZEN_REGISTRATIONS.EDUCATION_TYPE (ID,NAME) values (2,'Primary');
Insert into CITIZEN_REGISTRATIONS.EDUCATION_TYPE (ID,NAME) values (3,'Secondary');
Insert into CITIZEN_REGISTRATIONS.EDUCATION_TYPE (ID,NAME) values (4,'Bachelor');
Insert into CITIZEN_REGISTRATIONS.EDUCATION_TYPE (ID,NAME) values (5,'Master');
Insert into CITIZEN_REGISTRATIONS.EDUCATION_TYPE (ID,NAME) values (6,'Doctorate');
REM INSERTING into CITIZEN_REGISTRATIONS.GENDER
SET DEFINE OFF;
Insert into CITIZEN_REGISTRATIONS.GENDER (ID,NAME) values (1,'Male');
Insert into CITIZEN_REGISTRATIONS.GENDER (ID,NAME) values (2,'Female');
REM INSERTING into CITIZEN_REGISTRATIONS.PEOPLE
SET DEFINE OFF;
Insert into CITIZEN_REGISTRATIONS.PEOPLE (ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,GENDER_ID,HEIGHT,BIRTH_DATE,CURRENT_ADDRESS,PROFESSION) values (1,'Svetlana','Atanasova','Petrova',2,167,to_date('12-NOV-82','DD-MON-RR'),2,'engineer');
REM INSERTING into CITIZEN_REGISTRATIONS.PEOPLE_ADDRESSES
SET DEFINE OFF;
REM INSERTING into CITIZEN_REGISTRATIONS.PEOPLE_EDUCATIONS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PEOPLE_ADDRESSES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES_PK" ON "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PEOPLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CITIZEN_REGISTRATIONS"."PEOPLE_PK" ON "CITIZEN_REGISTRATIONS"."PEOPLE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index EDUCATIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CITIZEN_REGISTRATIONS"."EDUCATIONS_PK" ON "CITIZEN_REGISTRATIONS"."EDUCATIONS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PEOPLE_EDUCATIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS_PK" ON "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index GENDER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CITIZEN_REGISTRATIONS"."GENDER_PK" ON "CITIZEN_REGISTRATIONS"."GENDER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index EDUCATION_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CITIZEN_REGISTRATIONS"."EDUCATION_TYPE_PK" ON "CITIZEN_REGISTRATIONS"."EDUCATION_TYPE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index ADDRESSES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CITIZEN_REGISTRATIONS"."ADDRESSES_PK" ON "CITIZEN_REGISTRATIONS"."ADDRESSES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger ADDRESSES_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "CITIZEN_REGISTRATIONS"."ADDRESSES_TRG" 
BEFORE INSERT ON ADDRESSES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT ADDRESSES_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "CITIZEN_REGISTRATIONS"."ADDRESSES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger EDUCATIONS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "CITIZEN_REGISTRATIONS"."EDUCATIONS_TRG" 
BEFORE INSERT ON EDUCATIONS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT EDUCATIONS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "CITIZEN_REGISTRATIONS"."EDUCATIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PEOPLE_ADDRESSES_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES_TRG" 
BEFORE INSERT ON PEOPLE_ADDRESSES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PEOPLE_ADDRESSES_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PEOPLE_EDUCATIONS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS_TRG" 
BEFORE INSERT ON PEOPLE_EDUCATIONS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PEOPLE_EDUCATIONS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PEOPLE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "CITIZEN_REGISTRATIONS"."PEOPLE_TRG" 
BEFORE INSERT ON PEOPLE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "CITIZEN_REGISTRATIONS"."PEOPLE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Procedure ADD_ADDRESS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "CITIZEN_REGISTRATIONS"."ADD_ADDRESS" (
    country        IN    VARCHAR2,
    city           IN    VARCHAR2,
    municipality   IN    VARCHAR2,
    postal_code    IN    VARCHAR2,
    street         IN    VARCHAR2,
    nmbr           IN    VARCHAR2,
    floor          IN    NUMBER,
    apartmentno    IN    NUMBER,
    address_id     OUT   NUMBER
) AS
BEGIN
    INSERT INTO addresses (
        country,
        city, 
        municipality,
        postal_code,
        street,
        nmbr,
        floor,
        apartmentno
    ) VALUES (
        country,
        city, 
        municipality,
        postal_code,
        street,
        nmbr,
        floor,
        apartmentno
    ) RETURNING id INTO address_id;

END;

/
--------------------------------------------------------
--  Constraints for Table GENDER
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."GENDER" ADD CONSTRAINT "GENDER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."GENDER" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PEOPLE_EDUCATIONS
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" ADD CONSTRAINT "PEOPLE_EDUCATIONS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" MODIFY ("EDUCAION_ID" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" MODIFY ("PEOPLE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PEOPLE
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("PROFESSION" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" ADD CONSTRAINT "PEOPLE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("CURRENT_ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("BIRTH_DATE" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("GENDER_ID" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("MIDDLE_NAME" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PEOPLE_ADDRESSES
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" ADD CONSTRAINT "PEOPLE_ADDRESSES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" MODIFY ("ADDRESS_ID" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" MODIFY ("PERSON_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EDUCATION_TYPE
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATION_TYPE" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATION_TYPE" ADD CONSTRAINT "EDUCATION_TYPE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATION_TYPE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EDUCATIONS
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" ADD CONSTRAINT "EDUCATIONS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" MODIFY ("GRADUATED" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" MODIFY ("ENROLLMENT_DATE" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" MODIFY ("INSTITUTION_NAME" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" MODIFY ("TYPE_ID" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ADDRESSES
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" ADD CONSTRAINT "ADDRESSES_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" MODIFY ("NMBR" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" MODIFY ("STREET" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" MODIFY ("POSTAL_CODE" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" MODIFY ("MUNICIPALITY" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" MODIFY ("CITY" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" MODIFY ("COUNTRY" NOT NULL ENABLE);
  ALTER TABLE "CITIZEN_REGISTRATIONS"."ADDRESSES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table EDUCATIONS
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."EDUCATIONS" ADD CONSTRAINT "EDUCATIONS_FK1" FOREIGN KEY ("TYPE_ID")
	  REFERENCES "CITIZEN_REGISTRATIONS"."EDUCATION_TYPE" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PEOPLE
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" ADD CONSTRAINT "PEOPLE_FK1" FOREIGN KEY ("GENDER_ID")
	  REFERENCES "CITIZEN_REGISTRATIONS"."GENDER" ("ID") ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE" ADD CONSTRAINT "PEOPLE_FK2" FOREIGN KEY ("CURRENT_ADDRESS")
	  REFERENCES "CITIZEN_REGISTRATIONS"."ADDRESSES" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PEOPLE_ADDRESSES
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" ADD CONSTRAINT "PEOPLE_ADDRESSES_FK1" FOREIGN KEY ("PERSON_ID")
	  REFERENCES "CITIZEN_REGISTRATIONS"."PEOPLE" ("ID") ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_ADDRESSES" ADD CONSTRAINT "PEOPLE_ADDRESSES_FK2" FOREIGN KEY ("ADDRESS_ID")
	  REFERENCES "CITIZEN_REGISTRATIONS"."ADDRESSES" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PEOPLE_EDUCATIONS
--------------------------------------------------------

  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" ADD CONSTRAINT "PEOPLE_EDUCATIONS_FK1" FOREIGN KEY ("PEOPLE_ID")
	  REFERENCES "CITIZEN_REGISTRATIONS"."PEOPLE" ("ID") ENABLE;
  ALTER TABLE "CITIZEN_REGISTRATIONS"."PEOPLE_EDUCATIONS" ADD CONSTRAINT "PEOPLE_EDUCATIONS_FK2" FOREIGN KEY ("EDUCAION_ID")
	  REFERENCES "CITIZEN_REGISTRATIONS"."EDUCATIONS" ("ID") ENABLE;
