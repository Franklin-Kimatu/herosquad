SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heros (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  age integer NOT NULL ,
  power VARCHAR,
  weakness VARCHAR
);