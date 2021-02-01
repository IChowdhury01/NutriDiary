--Executed at startup.

--Create DB and tables
SELECT 'CREATE DATABASE <your db name>'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = '<your db name>')\gexec


CREATE TABLE IF NOT EXISTS users (
    id serial PRIMARY KEY NOT NULL,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(100) NOT NULL,
    profilePicture VARCHAR(100),
    weightChange DECIMAL(3,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS logs (
    date DATE NOT NULL,
    weight DOUBLE(4,1),
    calories SMALLINT(255),
    protein SMALLINT(255),
    userID serial UNIQUE
);

--Add foreign key to Logs, for 1-to-Many relationship.
ALTER TABLE A ADD CONSTRAINT userLogLink FOREIGN KEY (id) references logs(userID);

--Add or update tables with test record.
INSERT INTO users(username, password, weightChange)
VALUES('test', 'abc123', -1.50)
ON CONFLICT (username) DO UPDATE
  SET password excluded.password,
      weightChange = excluded.weightChange;

INSERT INTO logs(date, weight, calories, protein)
VALUES('2021-02-01', 152.5, 800, 120)
ON CONFLICT (date) DO UPDATE
  SET weight excluded.weight,
      calories = excluded.calories,
      protein = excluded.protein;