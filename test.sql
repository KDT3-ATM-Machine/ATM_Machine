CREATE table BankingUser(
                            UserId INT NOT NULL,
                            UserPw INT NOT NULL,
                            PRIMARY KEY (UserId)
);

CREATE table BankAccount(
                            AccountName VARCHAR(30) NOT NULL ,
                            Balance INT,
                            UserId INT NOT NULL,
                            PRIMARY KEY (AccountName),
                            FOREIGN KEY (UserId) REFERENCES BANKINGUSER (UserId)
);