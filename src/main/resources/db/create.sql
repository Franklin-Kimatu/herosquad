SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heros (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  age VARCHAR,
  power VARCHAR,
  weakness VARCHAR
);