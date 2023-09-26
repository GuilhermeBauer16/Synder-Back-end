CREATE TABLE client (
    id  PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,s
    telephone VARCHAR NOT NULL
);