CREATE TABLE IF NOT EXISTS blog.user_table(
user_id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS blog.post_table(
post_id INT PRIMARY KEY AUTO_INCREMENT,
post_head VARCHAR(20) NOT NULL,
post_body VARCHAR(500) NOT NULL,
post_date DATE,
user_id INT NOT NULL,
CONSTRAINT post_fk_user FOREIGN KEY (user_id)
REFERENCES user_table(user_id)
);


ALTER TABLE blog.user_table
ADD user_privs VARCHAR(5) NOT NULL;

INSERT INTO blog.post_table(post_head, post_body, post_date, user_id)
VALUES
('1. head', '1. body', 19/09/11, 1),
('2. head', '2. body', 19/09/11, 1),
('2. head - S', '2. body - S', 19/09/11, 2),
('2. head - S', '2. body - S', 19/09/11, 2);




INSERT INTO blog.user_table(username, password, user_privs)
VALUES
('Søren', 'test123', 'user'),
('Nicholas', 'test1234', 'admin');





DROP TABLE blog.user_table, blog.post_table;



SELECT * FROM blog.user_table LEFT JOIN blog.post_table ON user_table.user_id = post_table.user_id;

SELECT * FROM blog.post_table;

SELECT * FROM blog.user_table;

SELECT * FROM blog.user_table LEFT JOIN blog.post_table ON user_table.user_id = post_table.user_id;
