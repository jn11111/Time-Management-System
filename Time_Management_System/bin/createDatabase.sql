-- SQLite
CREATE TABLE employees (
    employeeID INTEGER PRIMARY KEY AUTOINCREMENT,
    firstName Varchar(55),
    lastName Varchar(55),
    email Varchar(55),
    employmentDate DATE DEFAULT CURRENT_DATE,
    position Varchar(128),
    adminAccess TINYINT DEFAULT 0);
create table getStatus (
	statusID INTEGER PRIMARY KEY AUTOINCREMENT,
	status varchar(25));
create table timestamps (
	TimeStampID INTEGER Primary key AUTOINCREMENT,
    employeeID int,
    TimeIn time,
    TimeOut time,
    TimeStampDate date,
    statusID INTEGER,
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
    statusID INTEGER,
    FOREIGN KEY (statusID) REFERENCES getStatus(statusID));