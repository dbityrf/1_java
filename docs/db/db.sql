CREATE TABLE course_2_student (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	course_id integer NOT NULL REFERENCES course(id),
	student_id integer NOT NULL REFERENCES person(id),
	grade integer NOT NULL 
);

CREATE TABLE person (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	noun varchar NOT NULL,
	email varchar NOT NULL,
	role_id integer NOT NULL REFERENCES role(id),
	created datetime NOT NULL,
	updated datetime NOT NULL
);

CREATE TABLE course (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	name varchar NOT NULL,
	address varchar NOT NULL,
	duration varchar NOT NULL,
	teacher_id integer NOT NULL REFERENCES person(id),
	start varchar NOT NULL,
	created datetime NOT NULL,
	updated datetime NOT NULL
);

CREATE TABLE role (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	name varchar NOT NULL
);





