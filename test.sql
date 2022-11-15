CREATE table BankingUser(
                            UserId VARCHAR(255) NOT NULL,
                            UserPw VARCHAR(255) NOT NULL,
                            PRIMARY KEY (UserId)
);

CREATE table BankAccount(
                            AccountName VARCHAR(30) NOT NULL ,
                            Balance INT,
                            UserId INT NOT NULL,
                            PRIMARY KEY (AccountName),
                            FOREIGN KEY (UserId) REFERENCES BANKINGUSER (UserId)
);

INSERT INTO BANKINGUSER (UserId, UserPw)
VALUES ('a1234','a123!@#');