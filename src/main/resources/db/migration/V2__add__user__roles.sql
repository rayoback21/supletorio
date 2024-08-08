CREATE TABLE IF NOT EXISTS users (
     id SERIAL PRIMARY KEY,
     username VARCHAR(20) UNIQUE,
     password VARCHAR(200),
     email VARCHAR(50) UNIQUE,
     locked BOOLEAN,
     disabled BOOLEAN
);

CREATE TABLE IF NOT EXISTS roles   (
   id SERIAL PRIMARY KEY,
   roles VARCHAR(25),
   user_id INT,
   FOREIGN KEY (user_id) REFERENCES users(id)
);