### Assignment 6 OOP with Design Patterns

Challenges:
- MYSQL has to be on and connected else will return null pointer exception
- Problems with creating UUID with database and builder pattern.

## loggy SQL
loggy.sql contains the DDL to assist in generating a schema and table on MYSQL
with an INSERT INTO statement to create the first record for viewing purposes when .war
file deployment.
MYSQL driver dependency is provided in libs.

## Taglibs and JSP
jsp and taglib dependacies within the lib directory. taglibs helps with rendering html on
jsp files to assist in retrieving and displaying values.

## user-page-logger.jsp
![Alt text](https://gyazo.com/4b85a9441a8c7068bfb06b4f3419c3f6 "Add, edit and delete logs")

## log-edit-page.jsp
![Alt text](https://gyazo.com/da106582a25505c88ae1974d26528c93 "The actual editing page")

## Uploading files
No actual file gets uploaded but is mocked by selecting from the dropdown menu. 
Name of title gets added to the file format and saved in a string within the database.

![Alt text](https://gyazo.com/0adba624647fa9f00582dd4119fe7b14 "Code snippet")