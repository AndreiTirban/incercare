CREATE TABLE TEAM
(
    ID              VARCHAR(36) NOT NULL
        CONSTRAINT PK_TEAM PRIMARY KEY,
    NAME            VARCHAR(255),
    NUMBER_OF_USERS INT
);