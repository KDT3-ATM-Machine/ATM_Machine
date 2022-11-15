CREATE table BankingUser(
                            UserId VARCHAR(255) NOT NULL,
                            UserPw VARCHAR(255) NOT NULL,
                            PRIMARY KEY (UserId)
);

CREATE table BankAccount(
                            AccountNum INT NOT NULL,
                            AccountName VARCHAR(30) NOT NULL ,
                            Balance INT,
                            UserId VARCHAR(255) NOT NULL,
                            PRIMARY KEY (AccountNum),
                            FOREIGN KEY (UserId) REFERENCES BANKINGUSER (UserId)
);

INSERT INTO BANKINGUSER (UserId, UserPw)
VALUES ('a1234','a123!@#');