# java-sql-builder
## Below are some examples showing how we can use this library.
### ALTER Queries
* Example-1
```sql
ALTER TABLE Student ADD ( AGE number(3))
```
```java
String alterAddQuery = SQLBuilder.write()
                                 .alter()
                                 .table("Student")
                                 .add()
                                 .column("AGE" ,"number(3)")
                                 .build();
```
* Example-2
```sql
ALTER TABLE Student ADD ( AGE number(3), COURSE varchar(40))
```
```java		
String alterAddQuery = SQLBuilder.write()
                                 .alter()
                                 .table("Student")
                                 .add()
                                 .columns("AGE number(3)","COURSE varchar(40)")
                                 .build();
```
* Example-3
```sql
ALTER TABLE Student MODIFY COURSE varchar(20)
```
```java		
String alterModifyQuery = SQLBuilder.write()
                                    .alter()
                                    .table("Student")
                                    .modifyColumn("COURSE", "varchar(20)")
                                    .build();
```
* Example-4
```sql
ALTER TABLE Student DROP COLUMN COURSE
```
```java		
String alterDropQuery = SQLBuilder.write()
                                  .alter()
                                  .table("Student")
                                  .dropColumn("COURSE")
                                  .build();
```
### CREATE Queries
* Example-1
```sql
CREATE TABLE Persons ( 
  PersonID int, 
  LastName varchar(255), 
  FirstName varchar(255), 
  Address varchar(255), 
  City varchar(255) 
)
```
```java
String createQuery = SQLBuilder.write()
                               .create()
                               .table("Persons")
                               .addColumnNameAndDataType("PersonID","int")
                               .addColumnNameAndDataType("LastName", "varchar(255)")
                               .addColumnNameAndDataType("FirstName", "varchar(255)")
                               .addColumnNameAndDataType("Address","varchar(255)")
                               .addColumnNameAndDataType("City","varchar(255)")
                               .build();
```

### DELETE Queries
* Example-1
```sql
DELETE FROM Customers
```
```java
String delQuery  =  SQLBuilder.write()
                              .delete()
                              .from("Customers")
                              .build();
```
* Example-2
```sql
DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste'
```
```java
String delQuery  =  SQLBuilder.write()
                              .delete()
                              .from("Customers")
                              .where()
                              .isEqual("CustomerName", "Alfreds Futterkiste")
                              .build();
```
### DROP Queries
* Example-1
```sql
DROP TABLE customers
```
```java		
String dropQuery  =  SQLBuilder.write()
                               .drop()
                               .table("customers")
                               .build();
```

### INSERT Queries
* Example-1
```sql
INSERT INTO 
Employee (CustomerName,ContactName,Address,City,PostalCode,Country) 
VALUES ('Cardinal','Tom B. Erichsen','Skagen 21','Stavanger','4006','Norway')
```
```java		
String insertQuery = SQLBuilder.write()
                               .insert()
                               .into("Employee")
                               .columns("CustomerName", "ContactName", "Address", "City", "PostalCode", "Country")
                               .values("Cardinal", "Tom B. Erichsen", "Skagen 21", "Stavanger", "4006", "Norway")
                               .build();
```
### UPDATE Queries
* Example-1
```sql
UPDATE Customers 
SET ContactName='Alfred Schmidt', City='Frankfurt' 
WHERE CustomerID=1
```
```java				
String updateQuery = SQLBuilder.write()
                               .update()
                               .table("Customers")
                               .set("ContactName","Alfred Schmidt")
                               .set("City", "Frankfurt")
                               .where()
                               .isEqual("CustomerID", 1)
                               .build();
```
