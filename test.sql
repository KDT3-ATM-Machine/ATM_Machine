CREATE table BankingUser(
                            UserId VARCHAR(255) NOT NULL,
                            UserPw VARCHAR(255) NOT NULL,
                            PRIMARY KEY (UserId)
);


CREATE table BankingAccount(
                            AccountNum VARCHAR(30),
                            AccountName VARCHAR(255),
                            Balance INT,
                            UserId VARCHAR(255) NOT NULL,
                            PRIMARY KEY (AccountNum),
                            FOREIGN KEY (UserId) REFERENCES BANKINGUSER (UserId)
);

// AccountName 은 userid랑 accountNum을 합친 것

user + (tostring)accountNum = accountname
userId+accountName =accountStr

INSERT INTO BANKINGUSER (UserId, UserPw)
VALUES ('a1234','a123!@#');