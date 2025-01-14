![122](https://github.com/user-attachments/assets/122c6ee6-2bde-4246-b4c3-0cd607ae8c9e)
![123](https://github.com/user-attachments/assets/24d80fc8-215b-4dee-ac99-f8ab2d26e764)
![124](https://github.com/user-attachments/assets/35273003-871d-4370-84cb-d5b50b0a6b5e)
![125](https://github.com/user-attachments/assets/4091c5e9-2abb-4d92-846c-1b2e5496ecd9)
![126](https://github.com/user-attachments/assets/c1bb71fa-60da-4b88-98e5-c2243f3a0e5b)
![127](https://github.com/user-attachments/assets/7971df4b-0e09-452e-9f7b-0418be638b53)
![database](https://github.com/user-attachments/assets/78fba5bb-df00-4eb9-92da-097c30bd2649)

# Usage
# Sign Up:

Go to /signup to create a new user account.
# Log In:

Go to /signin to log in with your credentials.
Manage Tasks:

# After logging in, you can:
View all your tasks on the dashboard.
Create new tasks.
Edit or delete existing tasks.


# API Endpoints Authentication


Endpoint ->Method	Description

/signup	->GET	Displays the signup form.

/signup ->	POST	Handles user registration.

/signin ->	GET	Displays the login form.


Tasks

# Endpoint	Method	Description


/	GET	Displays -> tasks for the logged-in user.

/tasks/create	 -> GET	Displays the task creation form.

/	POST ->	Creates a new task.

/{id} ->	GET	Fetches details of a specific task.

/{id}/edit -> GET	Displays the edit form for a task.

/{id}	POST ->	Updates an existing task.

/{id}/delete ->	POST	Deletes a task.


# Technologies Used


Spring Boot: Framework for building the application

Spring Security: Authentication and authorization

Thymeleaf: Templating engine for rendering HTML

MySQL: Database for storing user and task data

Maven: Build and dependency management

Java 17: Programming language


# Database Configuration

JDBC URL for database connection

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name

 Database username
 
spring.datasource.username=your_username

 Database password
 
spring.datasource.password=your_password

 Database driver class
 
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


