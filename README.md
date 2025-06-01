GhostNet WebApp

This app allows the tracking of lost fishing nets - Ghost Nets.
Logged in users can change the status of nets to let others know, if a net will be retrieved by you.

**App Setuo:**  
Install a MySQL database.  
Create the ghostnet database with `$> mysqladmin create ghostnetdb`.  
Create database user = `dbuser` with password `12345`.  
Import the sql dump file `ghostnet_dump.sql` to your MySQL database using `$> mysql ghostnetdb < ghostnet_dump.sql`.  

Run `./mvnw clean install` to compile and test the application.  
Run `./mvnw spring-boot:run` to start the application on `localhost:8080`.  

**Test User:**  
User: `Tester`  
Password: `tester`  
You can also create your own user.  

**Enjoy! :)**

 
