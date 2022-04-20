### MVC Design Pattern Example

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
![user page example](https://user-images.githubusercontent.com/81432643/145195440-56364262-8074-4a6a-a43c-708a0dae3fba.png)

## log-edit-page.jsp
![edit page example](https://user-images.githubusercontent.com/81432643/145195559-ff88a7d9-63c6-4bb6-808e-153d383971a0.png)

## Uploading files
No actual file gets uploaded but is mocked by selecting from the dropdown menu. 
Name of title gets added to the file format and saved in a string within the database.

![fileattached snippet](https://user-images.githubusercontent.com/81432643/145195639-6919dc21-ffad-4f88-935d-9437044d6d5d.png)
