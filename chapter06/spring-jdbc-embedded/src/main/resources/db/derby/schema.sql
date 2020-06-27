CREATE TABLE SINGER
(
    ID         INT         NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    FIRST_NAME VARCHAR(60) NOT NULL,
    LAST_NAME  VARCHAR(40) NOT NULL,
    BIRTH_DATE DATE,
    CONSTRAINT SINGER_PK PRIMARY KEY (ID)
);

ALTER TABLE SINGER
    ADD CONSTRAINT UQ_SINGER_1 UNIQUE (FIRST_NAME, LAST_NAME);

CREATE TABLE ALBUM
(
    ID           INT          NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    TITLE        VARCHAR(100) NOT NULL,
    RELEASE_DATE DATE,
    SINGER_ID    INT CONSTRAINT FK_ALBUM REFERENCES SINGER ON DELETE CASCADE,
    CONSTRAINT ALBUM_PK PRIMARY KEY (ID)
);

ALTER TABLE ALBUM
    ADD CONSTRAINT UQ_SINGER_ALBUM_1 UNIQUE (SINGER_ID, TITLE);
