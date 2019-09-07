SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS tasks (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  age int,
  power VARCHAR,
  weakness VARCHAR
);