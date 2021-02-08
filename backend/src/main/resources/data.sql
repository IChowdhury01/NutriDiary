--This PostgreSQL script will run when the Spring Boot app is initialized. It adds test entries to the database.

--Empty tables at startup. Disable for DEPLOYMENT.
TRUNCATE users CASCADE;
TRUNCATE logs CASCADE;
--TRUNCATE users_logs CASCADE;

--Add test entries to users table
INSERT INTO users (id, username, password, goalWWC, profile_pic)
VALUES(1,'Ivan','1234', 1.50,'/images/blank-profile.png');

INSERT INTO users (id, username, password, goalWWC, profile_pic)
VALUES(2,'Farhan','4567',-2.00, '/images/blank-profile.png');

INSERT INTO users (id, username, password, goalWWC, profile_pic)
VALUES(3,'Moaggaim','sgt5365tg',-0.50, '/images/blank-profile.png');

--Add test entries to logs table
INSERT INTO logs (id, log_date, weight, calories, protein, user_id)
VALUES(1, '2021-02-07', 150.5, 800, 100, 1);

INSERT INTO logs (id, log_date, weight, calories, protein, user_id)
VALUES(2, '2021-01-31', 170.5, 450, 100, 1);

INSERT INTO logs (id, log_date, weight, calories, protein, user_id)
VALUES(3, '2020-12-31', 130.5, 1500, 50, 2);

--Add test entries to user-log mapping table
--INSERT INTO users_logs (user_id, logs_id)
--VALUES(1,1);
--
--INSERT INTO users_logs (user_id, logs_id)
--VALUES(1,2);
--
--INSERT INTO users_logs (user_id, logs_id)
--VALUES(2,3);