CREATE TABLE person(
    identification VARCHAR(36) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    gender CHAR(1) NOT NULL,
    age INT,
    CHECK(age >=1),
    address VARCHAR(50) NOT NULL,
    phone  VARCHAR(10) NOT NULL
);

CREATE TABLE customer(
    identification VARCHAR(36) PRIMARY KEY,
    password VARCHAR(32) NOT NULL,
    state boolean NOT NULL,
    FOREIGN KEY (identification) REFERENCES person(identification)
);

CREATE TABLE account(
    account_number VARCHAR(36) PRIMARY KEY,
    account_type VARCHAR(10) NOT NULL,
    initial_balance DECIMAL NOT NULL,
    state boolean NOT NULL,
    id_customer VARCHAR(36), FOREIGN KEY (id_customer) REFERENCES customer(identification)
);

CREATE TABLE movements(
	id_movement VARCHAR(36) PRIMARY KEY,
    type_movement VARCHAR(8) NOT NULL,
    date_mov TIMESTAMP not null,
    value_mov DECIMAL NOT NULL,
    balance DECIMAL NOT NULL,
    id_account VARCHAR(36),
    FOREIGN KEY (id_account) REFERENCES account(account_number)
    );

