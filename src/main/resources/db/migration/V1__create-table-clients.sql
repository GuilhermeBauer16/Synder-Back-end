CREATE TABLE client (
    id bigserial PRIMARY KEY,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    telephone varchar(20) NOT NULL
);
