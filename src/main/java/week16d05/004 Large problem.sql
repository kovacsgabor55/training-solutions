# Problem Statement
CREATE DATABASE `management`; 
USE `management`;
-- Note management app (similar to Google Keep) is used to take notes, 
-- add notes into categories 
-- and set reminders for a note. 

-- Create the necessary DB schema (MySQL) including
-- tables, relationships, triggers and add sample data into each table.

###User table fields: user_id, user_name, user_added_date, user_password, user_mobile
CREATE TABLE usertable( /*users*/
	user_id INT PRIMARY KEY, 
	user_name VARCHAR(20), 
	user_added_date DATETIME, 
	user_password VARCHAR(20), 
	user_mobile INT);
	

	
###Reminder table fields : reminder_id, reminder_name, reminder_descr, reminder_type, reminder_creation_date, reminder_creator
CREATE TABLE remindertable(
	reminder_id INT PRIMARY KEY,
	reminder_name VARCHAR(30), 
	reminder_descr VARCHAR(100),
	reminder_type VARCHAR(20),
	reminder_creation_date DATETIME,
	reminder_creator VARCHAR(20));


###Note table fields: note_id, note_title, note_content, note_status, note_creation_date
CREATE TABLE notetable( /*notes*/
	note_id INT PRIMARY KEY,
	note_title VARCHAR(20), 
	note_content VARCHAR(200),
	note_status VARCHAR(10), 
	note_creation_date DATETIME);
	
###Category table fields : category_id, category_name, category_descr, category_creation_date, category_creator
CREATE TABLE categorytable(
	category_id INT PRIMARY KEY,
	category_name VARCHAR(30), 
	category_descr VARCHAR(100),
	category_creation_date DATETIME,
	category_creator VARCHAR(20));

	
###NoteCategory table fields : notecategory_id, note_id, category_id
CREATE TABLE notecategorytable(
	notecategory_id INT PRIMARY KEY, 
	note_id INT, 
	category_id INT,
	CONSTRAINT `fk_notetable`
		FOREIGN KEY f1(note_id) 
			REFERENCES notetable(note_id) 
				ON UPDATE CASCADE 
				ON	DELETE CASCADE, 
	CONSTRAINT `fk_categorytable`
		FOREIGN KEY f2(category_id) 
			REFERENCES categorytable(category_id) 
				ON UPDATE CASCADE 
				ON	DELETE CASCADE
);

###Notereminder table fields : notereminder_id, note_id, reminder_id
CREATE TABLE noteremindertable(
	notereminder_id INT PRIMARY KEY, 
	note_id INT, 
	reminder_id INT, 
	CONSTRAINT `fk_notetable2`
		FOREIGN KEY f1(note_id) 
			REFERENCES notetable(note_id) ON
				UPDATE CASCADE ON
				DELETE CASCADE, 
	CONSTRAINT `fk_remindertable2`
		FOREIGN KEY f2(reminder_id) 
			REFERENCES remindertable(reminder_id) ON
				UPDATE CASCADE ON
				DELETE CASCADE
);


###usernote table fields : usernote_id, user_id, note_id
CREATE TABLE usernotetable(
	usernote_id INT PRIMARY KEY, 
	user_id INT, 
	note_id INT, 
-- constraint
)



###Insert the rows into the created tables (Note, Category, Reminder, User, UserNote, NoteReminder and NoteCategory).
INSERT INTO usertable VALUES(	102,"Jaspal","2019-01-30 12:34:48","Secret*",789643495);
INSERT INTO notetable VALUES(1,"Catch flight","Reach airpot by 4","Tomorrow","2019-02-02 03:24:56");
INSERT INTO categorytable VALUES(11,"Reminder","Flight Boarding Reminder","2019-02-02 03:24:56","Self");
INSERT INTO remindertable VALUES(50,"Flight Reminder","Flight Boarding Reminder","All Day","2019-02-02 03:24:56","User");
INSERT INTO notecategorytable VALUES(9,1,11);
INSERT INTO noteremindertable VALUES(51,1,50);
INSERT INTO usernotetable VALUES(66,102,1);

###Fetch the row from User table based on Id and Password.
###Fetch all the rows from Note table based on the field note_creation_date.
###Fetch all the Categories created after the particular Date.
###Fetch all the Note ID from UserNote table for a given User.
###Write Update query to modify particular Note for the given note Id.
###Fetch all the Notes from the Note table by a particular User.
###Fetch all the Notes from the Note table for a particular Category.
###Fetch all the reminder details for a given note id.
###Fetch the reminder details for a given reminder id.


###Write a query to create a new Note from particular User (Use Note and UserNote tables - insert statement).

###Write a query to create a new Note from particular User to particular Category(Use Note and NoteCategory tables - insert statement)

###Write a query to set a reminder for a particular note (Use Reminder and NoteReminder tables - insert statement)

###Write a query to delete particular Note added by a User(Note and UserNote tables - delete statement)

###Write a query to delete particular Note from particular Category(Note and NoteCategory tables - delete statement)

###Create a trigger to delete all matching records from UserNote, NoteReminder and NoteCategory table when :
--	1. A particular note is deleted from Note table (all the matching records from UserNote, NoteReminder and NoteCategory should be removed automatically) 
--	2. A particular user is deleted from User table (all the matching notes should be removed automatically)