
-- MYSQL dependent.
-- user:root
-- pass:CST2355Database
CREATE SCHEMA if not exists loggy;
CREATE TABLE `log`(
    `UuID` VARCHAR(40) COLLATE utf8_unicode_ci NOT NULL,
    `Title` VARCHAR(60) COLLATE utf8_unicode_ci DEFAULT NULL,
    `Content` VARCHAR (120) COLLATE utf8_unicode_ci,
    `CreateTimestamp` VARCHAR(40) DEFAULT NULL,
    `FileType` VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (`UuID`))
ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO loggy.log (UuID,Title,Content,CreateTimestamp,FileType) VALUES ('aaaaaaaa-bbbb-cccc-dddd-111111111111', 'Initial submission','This is my first submission to the thread, its a really nice assignment!',NULL,'Initial Submission.txt');

