# JDBC CRUDs
_**Creating, reading, updating,** and **deleting** data in a database is a common task in many applications, and **JDBC (Java Database Connectivity)** is a **Java API** that allows you to connect to a database and perform these operations._

## Steps of setting up a simple _CRUD (create, read, update, delete)_ operation using _JDBC._
### 1. Connect to the database :
_The first step is to establish a connection to the database. You can do this by loading the JDBC driver and creating a connection object._
```java
try { 
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection con = DriverManager.getConnection( 
		"jdbc:mysql://localhost:3306/mydb", "username", 
		"password"); 
	System.out.println("Connection established."); 
} 
catch (Exception e) { 
	e.printStackTrace(); 
}
```
