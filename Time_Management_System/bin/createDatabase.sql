-- SQLite
CREATE TABLE employees (
    employeeID INTEGER PRIMARY KEY AUTOINCREMENT,
    firstName Varchar(55),
    lastName Varchar(55),
    email Varchar(55),
    employmentDate DATE DEFAULT CURRENT_DATE,
    position Varchar(128),
    adminAccess TINYINT DEFAULT 0);
    INSERT INTO employees (firstname, lastname, email, position, adminAccess)
VALUES("admin","admin","admin","admin",1),
("test1","test1","test1","test1",0);
create table getStatus (
	statusID INTEGER PRIMARY KEY AUTOINCREMENT,
	status varchar(25));
INSERT INTO getStatus(status) 
    VALUES("PENDING"),
        ("APPROVED"),
        ("DENIED");
create table timestamps (
	TimeStampID INTEGER Primary key AUTOINCREMENT,
    employeeID int,
    TimeIn time DEFAULT CURRENT_TIME,
    TimeOut time,
    TimeStampDate date DEFAULT CURRENT_DATE,
    statusID INTEGER  DEFAULT 1,
    foreign key (employeeID) references employees(employeeID),
    foreign key (statusID) references getStatus(statusID));
create table incomings(
	incomingID INTEGER PRIMARY KEY AUTOINCREMENT,
    firstName Varchar(55),
    lastName Varchar(55),
    email Varchar(55),
    applicationDate DATE DEFAULT CURRENT_DATE,
    reason TEXT,
    feedback TEXT,
    statusID INTEGER DEFAULT 1,
    FOREIGN KEY (statusID) REFERENCES getStatus(statusID));
INSERT Into incomings(firstname, lastname, email) 
VALUES("John Nicole", "Diosa", "jndiosa111@gmail.com");
