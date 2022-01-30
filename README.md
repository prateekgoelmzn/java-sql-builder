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
