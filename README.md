# java-sql-builder
[Click her to download Jar File](https://github.com/prateekgoelmzn/java-sql-builder/blob/main/java-sql-builder-0.0.1-SNAPSHOT.jar)
## Below are some examples showing how we can use this library.
### SELECT Queries
* Example-1
```sql
SELECT * FROM Employee
```
```java				
String selectAllQuery = SQLBuilder.write()
                                  .select()
                                  .all()
                                  .from("Employee")
                                  .build();
```

* Example-2
```sql
SELECT * FROM Employee WHERE empId IN ('abc','def','ghi','jkl')
```
```java						
String selectInQuery = SQLBuilder.write()
                                 .select()
                                 .all()
                                 .from("Employee")
                                 .where()
                                 .in("empId","abc","def","ghi","jkl")
                                 .build();
```
```java								
String selectInStringsQuery = SQLBuilder.write()
                                        .select()
                                        .all()
                                        .from("Employee")
                                        .where()
                                        .in("empId", Arrays.asList( "abc","def","ghi","jkl"))
                                        .build();
```
* Example-3
```sql
SELECT * FROM Employee WHERE empId IN (1234,321,456,9875)
```
```java						
String selectInIntegerQuery = SQLBuilder.write()
                                        .select()
                                        .all()
                                        .from("Employee")
                                        .where()
                                        .in("empId", Arrays.asList( 1234,321,456,9875))
                                        .build();
```
* Example-4
```sql
SELECT * FROM Employee WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30
```
```java								
String selectAllQuery = SQLBuilder.write()
                                  .select()
                                  .all()
                                  .from("Employee")
                                  .where()
                                  .isEqual("EmployeeName","ABCD")
                                  .andBetween("EmployeeAge", 21, 30)
                                  .build();
```

* Example-5
```sql
SELECT empname,empSalary,empDepratment FROM Employee 
WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30
```
```java										
String selectColumnsQuery = SQLBuilder.write()
                                      .select()
                                      .columns(Arrays.asList("empname","empSalary","empDepratment"))
                                      .from("Employee")
                                      .where()
                                      .isEqual("EmployeeName","ABCD")
                                      .andBetween("EmployeeAge", 21, 30)
                                      .build();
```
* Example-6
```sql
SELECT empname,empSalary FROM Employee 
WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30
```
```java										
String selectAllQuery = SQLBuilder.write()
                                  .select()
                                  .columns("empname","empSalary")
                                  .from("Employee")
                                  .where()
                                  .isEqual("EmployeeName","ABCD")
                                  .andBetween("EmployeeAge", 21, 30)
                                  .build();
```
* Example-7
```sql
SELECT empname,empSalary FROM Employee 
WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30 AND empDept='ABCD' AND empage>34
```
```java										
String selectAllQuery = SQLBuilder.write()
                                  .select()
                                  .columns("empname","empSalary")
                                  .from("Employee")
                                  .where()
                                  .isEqual("EmployeeName","ABCD")
                                  .andBetween("EmployeeAge", 21, 30)
                                  .andIsEqual("empDept", "ABCD")
                                  .andIsGreaterThen("empage", 34)
                                  .build();
```

* Example-8
```sql
SELECT s.last_name,s.first_name,p.course_code, p.status, p.amount 
FROM enrollment e 
join student s 
ON s.id=e.student_id 
join payment p 
ON p.course_code=e.course_code 
AND p.student_id=e.student_id
```
```java										
String selectJoinQuery = SQLBuilder.write()
                                   .select()
                                   .columns("s.last_name","s.first_name","p.course_code"," p.status"," p.amount")
                                   .from("enrollment e")
                                   .join("join", "student s")
                                   .on("s.id", "e.student_id")
                                   .join("join", "payment p")
                                   .on("p.course_code","e.course_code")
                                   .and("p.student_id","e.student_id")
                                   .build();
```

* Example-9
```sql
SELECT * FROM supplier ORDER BY last_name DESC
```
```java										
String selectOrderByQuery = SQLBuilder.write()
                                      .select()
                                      .all()
                                      .from("supplier")
                                      .orderBy("last_name",Order.DESC)
                                      .build();
```

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
