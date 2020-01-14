INSERT INTO employee(id, name, age) VALUES (1, '派遣 野郎', 30)
,(2, '派遣 野郎2', 0)
,(3, '派遣 野郎2', 200)
,(4, '派遣 野郎2', -1)
,(5, '派遣 野郎3', 201)
;

INSERT INTO users(id, password, name, birthday, age, marrige, role) VALUES
('admin@sample.com','$2a$10$po9k73hKiGuibT6rZcglu.vGSBXU8cZu3HcyeUdcW2WN8R3h6aQdO','Name1', '2000-01-01', 18, true, 'ROLE_ADMIN')
,('general@sample.com','$2a$10$po9k73hKiGuibT6rZcglu.vGSBXU8cZu3HcyeUdcW2WN8R3h6aQdO','Name2', '2000-01-02', 20, true, 'ROLE_GENERAL')
,('test','$2a$10$LeEbDF7Tgv1pzDq/cda4Qemyqvot0xgWTQPkG6g.lbgHu/gBBg7J.','Name3', '2000-01-03', 30, true, 'ROLE_ADMIN')
,('user','$2a$10$LeEbDF7Tgv1pzDq/cda4Qemyqvot0xgWTQPkG6g.lbgHu/gBBg7J.','Name4', '2000-01-04', 40, false, 'ROLE_GENERAL')
,('5','password','Name5', '2000-01-05', 50, true, 'ROLE_GENERAL')
,('6','password','Name6', '2000-01-06', 60, true, 'ROLE_GENERAL')
,('7','password','Name7', '2000-01-07', 70, false, 'ROLE_GENERAL')
;