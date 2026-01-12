INSERT INTO user_details (id, name, birth_date)
VALUES (10001, 'Sudeshna', current_date());

INSERT INTO user_details (id, name, birth_date)
VALUES (10002, 'Jolly', current_date());

INSERT INTO user_details (id, name, birth_date)
VALUES (10003, 'Joy', current_date());

INSERT INTO post(id , description , user_id)
VALUES (20001, 'I want to learn AWS', 10001);

INSERT INTO post(id , description , user_id)
VALUES (20002, 'I want to learn DevOps', 10001);

INSERT INTO post(id , description , user_id)
VALUES (20003, 'I want to learn Docker', 10002);

INSERT INTO post(id , description , user_id)
VALUES (20004, 'I want to learn Kubernetes', 10002);
