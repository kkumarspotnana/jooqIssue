
CREATE EXTENSION IF NOT EXISTS citext;
drop TABLE if exists testTable;

CREATE TABLE testTable (
    id INT PRIMARY KEY,
    name_varchar VARCHAR(255),
    name_text text,
    name_citext citext
);

INSERT INTO testTable (id, name_varchar,name_text,name_citext) VALUES (1, 'testValue','testValue','testValue');

INSERT INTO testTable (id, name_varchar,name_text,name_citext) VALUES (2, 'testvalue','testvalue','testvalue');

