CREATE TABLE CONTACT_DETAILS
(
ID BIGINT(20) NOT NULL AUTO_INCREMENT,
PHONE VARCHAR(30)NOT NULL,
COUNTRY VARCHAR(50) NOT NULL,
CITY VARCHAR(50) NOT NULL,
WEBSITE VARCHAR(50) DEFAULT NULL,
STREET_NAME VARCHAR(50) NOT NULL,
STREET_NUMBER VARCHAR(50) NOT NULL,
PRIMARY KEY (ID),
CONSTRAINT FK_CONTACT_USER_CONSTRAINT FOREIGN KEY(ID) REFERENCES USER_TABLE(ID)
)