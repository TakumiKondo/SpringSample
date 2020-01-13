INSERT INTO employee(id, name, age) VALUES (1, '派遣 野郎', 30)
,(2, '派遣 野郎2', 0)
,(3, '派遣 野郎2', 200)
,(4, '派遣 野郎2', -1)
,(5, '派遣 野郎3', 201)
;

INSERT INTO users(id, password, name, birthday, age, marrige, role) VALUES
('1','password','Name1', '2000-01-01', 18, true, 'ROLE_ADMIN')
,('2','password','Name2', '2000-01-02', 20, true, 'ROLE_ADMIN')
,('3','password','Name3', '2000-01-03', 30, true, 'ROLE_ADMIN')
,('4','password','Name4', '2000-01-04', 40, false, 'ROLE_ADMIN')
,('5','password','Name5', '2000-01-05', 50, true, 'ROLE_STAFF')
,('6','password','Name6', '2000-01-06', 60, true, 'ROLE_STAFF')
,('7','password','Name7', '2000-01-07', 70, false, 'ROLE_STAFF')
;