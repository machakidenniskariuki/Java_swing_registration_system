This Java Swing application is designed for managing a registration system with a MySQL database. The application allows users to:

Add New Records: Users can register new entries by filling in details such as ID, Name, Gender, Address, and Contact, and then clicking the "Register" button. This information is then inserted into a MySQL database.

View Records: The application fetches records from the MySQL database and displays them in a table. The upDateDB() method is used to update the displayed table with the latest data from the database.

Update Records: Users can update existing records by modifying the details in the text fields and clicking the "Update" button. The record with the specified ID will be updated with the new details in the database.

Delete Records: Users can delete records from the database by specifying the ID of the record they want to delete and clicking the "Delete" button.

Exit Application: Users can exit the application by clicking the "Exit" button, which prompts for confirmation before closing the application.
