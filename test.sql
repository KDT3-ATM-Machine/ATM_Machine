CREATE table BankingUser(
                            UserId VARCHAR(255) NOT NULL,
                            UserPw VARCHAR(255) NOT NULL,
                            PRIMARY KEY (UserId)
);


CREATE table BankingAccount(
                            AccountNum VARCHAR(30) NOT NULL ,
                            AccountName VARCHAR(255) NOT NULL ,
                            Balance INT default 0,
                            UserId VARCHAR(255) NOT NULL,
                            PRIMARY KEY (AccountNum),
                            FOREIGN KEY (UserId) REFERENCES BANKINGUSER (UserId)
);


INSERT INTO BANKINGUSER (UserId, UserPw)
VALUES ('a1234','a123!@#');

INSERT INTO BANKINGACCOUNT(AccountNum, AccountName, Balance, UserId)
VALUES ('2','고객',0,'가나다');


