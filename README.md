# Employee Management System (Lambton College)

This is a Java EE-based Employee Management application designed for managing employee records for Lambton College. The system allows users to perform CRUD (Create, Read, Update, Delete) operations on employee data, stored in a MySQL database. The project utilizes JSP, Servlets, and the Model-View-Controller (MVC) pattern.

## Features
- Add, view, edit, and delete employees.
- Uses JSP and Servlets for backend logic.
- Stores employee records in a MySQL database.

## Technologies Used
- **Frontend:** JSP, Bootstrap  
- **Backend:** Java EE (Servlets, JSP)  
- **Database:** MySQL (JDBC Connectivity)  
- **Tools:** Eclipse, MySQL Workbench  

## Setup Instructions

Clone the repository and add your own database credentials in the Controller.java file to connect to MySQL.
Make sure to configure your MySQL database with the appropriate schema for employee data.

1. Clone the repository:
   ```bash
   git clone https://github.com/Vishvas810/EmpzDbApp

2. Add your MySQL database credentials in Controller.java.
3. Run the application on a Tomcat server.


## Screenshots  

1. **Home Page**  
   The landing page of the Employee Management System where users can navigate to different functionalities.  
   ![Home Page](screenshots/homepage.png)  

2. **Add Employee Page**  
   A form where users can enter details to add a new employee.  
   ![Add Employee](screenshots/add_employee.png)  

3. **Success Message**  
   A confirmation message displayed after successfully adding a new employee.  
   ![Success](screenshots/success.png)  

4. **View Employees**  
   A list of all employees stored in the database, displayed in a table format.  
   ![View Employees](screenshots/view_employees.png)  

5. **Edit Employee**  
   A page where users can update an employee's information, with prefilled existing details.  
   ![Edit Employee](screenshots/edit_employee.png)  

6. **Updated Employee Details**  
   The updated employee information is reflected in the list after editing.  
   ![Updated Employee](screenshots/updated_employee.png)  

7. **Delete Employee**  
   A delete button to remove an employee from the system. For example, record 5 is deleted, and the updated list is displayed.  
   ![Delete Employee](screenshots/delete_employee.png)  
