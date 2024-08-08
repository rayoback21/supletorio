CREATE TABLE IF NOT EXISTS team(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL
    );



CREATE TABLE IF NOT EXISTS player(
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL ,
    age VARCHAR(50) NOT NULL,
    positione VARCHAR(255) NOT NULL,
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES team(id)
    );


