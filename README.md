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


