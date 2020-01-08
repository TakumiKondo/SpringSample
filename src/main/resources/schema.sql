CREATE TABLE IF NOT EXISTS employee (
	id INT PRIMARY KEY
	,name VARCHAR(100)
	,age INT
);

CREATE TABLE IF NOT EXISTS users (
	id VARCHAR(50) PRIMARY KEY
	,password VARCHAR(100)
	,name VARCHAR(50)
	,birthday DATE
	,age INT
	,marrige BOOLEAN
	,role VARCHAR(50)
);