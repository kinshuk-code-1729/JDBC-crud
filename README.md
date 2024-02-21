# JDBC CRUDs
_**Creating, reading, updating,** and **deleting** data in a database is a common task in many applications, and **JDBC (Java Database Connectivity)** is a **Java API** that allows you to connect to a database and perform these operations._

### Steps of setting up a simple _CRUD (create, read, update, delete)_ operation using _JDBC :_

## 1. Connect to the database :
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

## 2. Create a new record :
_Once you have a connection to the database, you can use the connection object to create a new record in the database. To do this, you will need to use an SQL INSERT statement and execute it using the connection object._
```java
try { 
String sql = "INSERT INTO table_name (column1, column2, column3) VALUES (?, ?, ?)"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setString(1, "value1"); 
statement.setString(2, "value2"); 
statement.setInt(3, 123); 
statement.executeUpdate(); 
System.out.println("Record created."); 
} catch (SQLException e) { 
e.printStackTrace(); 
}
```

## 3. Read a record :
_To read a record from the database, you will need to use an SQL SELECT statement and execute it using the connection object. The result of the query will be a ResultSet object that you can use to access the data in the record._
```java
try { 
String sql = "SELECT column1, column2, column3 FROM table_name WHERE id = ?"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setInt(1, 1); 
ResultSet result = statement.executeQuery(); 
if (result.next()) { 
	String column1 = result.getString("column1"); 
	String column2 = result.getString("column2"); 
	int column3 = result.getInt("column3"); 
	System.out.println("Column 1: " + column1); 
	System.out.println("Column 2: " + column2); 
	System.out.println("Column 3: " + column3); 
} 
} catch (SQLException e) { 
e.printStackTrace(); 
}
```

## 4. Update a record :
_To update a record in the database, you will need to use an SQL UPDATE statement and execute it using the connection object._
```java
try { 
String sql = "UPDATE table_name SET column1 = ?, column2 = ?, column3 = ? WHERE id = ?"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setString(1, "new_value1"); 
statement.setString(2, "new_value2"); 
statement.setInt(3, 456); 
statement.setInt(4, 1); 
statement.executeUpdate(); 
System.out.println("Record updated."); 
} catch (SQLException e) { 
e.printStackTrace(); 
}
```

## 5. Delete a record :
_To delete a record from the database, you will need to use an SQL DELETE statement and execute it using the connection object._
```java
try { 
String sql = "DELETE FROM table_name WHERE id = ?"; 
PreparedStatement statement = con.prepareStatement(sql); 
statement.setInt(1, 1); 
statement.executeUpdate(); 
System.out.println("Record deleted."); 
} catch (SQLException e) { 
e.printStackTrace(); 
}
```
