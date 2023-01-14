# Saif Solutions Internship

## Subtotal Calculator

Calculates subtotals from a file containing financial transactions/expenses and sends it as an email

<p align="center">
  <img src= "https://user-images.githubusercontent.com/85238036/212371938-7aa764fb-d55d-47e6-bb95-0763257f17ed.jpeg" height = "300" />
  <img src= "https://user-images.githubusercontent.com/85238036/212372106-5c9122d5-2f0e-4663-aca0-9e1774f548a6.jpeg" height = "300"/>
</p>

![New Note](https://user-images.githubusercontent.com/85238036/212373250-f2bd3d59-f025-4a42-877a-176c9bf3de57.jpeg)


### Overview

This subtotal calculator is made for anyone (ideally small business owners) who want to keep track of their expenses. This calculator reads in a CSV file containing transactions from throughout a time period, modifies this data so that it groups and adds all similar transaction amounts and then automatically sends this updataed data in an new attached CSV file via email. This makes it easier for the user to understand which categories of their expenses can be cut down and can help them get a better understanding of how to appropriately budget their money.

### Build Process

Technologies Used: Java. Maven, JavaMail API

First, I created a method called readFile which reads in the original CSV file with all of the ungrouped transactions using the BufferedReader class. Each row is read one by one into a Transaction class which contains three parameters: date, purchase and cost. Then, each object (representing a single row) is stored in an ArrayList. If a file has more than just three columns, this object can be easily modified so it contains additional parameters. 

Second, once all the rows have been read, they are modified by the getOutputArray method which groups all similar transactions and stores it into an new ArrayList of objects. 

Third, the new ArrayList is written into a new CSV file in the form of a chart. Then, in the final method, the JavaMail API is called to send this new CSV file as an email. In order to use the JavaMail API I realized that I needed to use use Maven and add the JavaMail dependency to the pom.xml file. 

### Improvements

At first, I opted to store the original data in a HashMap instead of an ArrayList of objects. While this original method was faster, the code was much cleaner and easier to understand when I re-wrote it using an ArrayList of objects. Ultimately, by re-writing the code using an ArrayList of objects instead of a HashMap, I sacrificed a little bit of speed in favor of readability, scalability as well as being able to easily refactor it in the future.

### How to use

Download the source code, go to the TransactionDriver.java file and run the program. The driver class calls the methods readFile, getOutputArray, writeFile and sendEmail from the TransactionSubtotals class.

<br>

## CRUD RESTful API

Inputs financial transaction data into a mySQL database and on the web. Data can be inputted, read, updated and deleted from this database.

![New Note](https://user-images.githubusercontent.com/85238036/212412499-712bd653-5f89-4cc8-b990-c9a1f64d72b4.jpeg)

![New Note](https://user-images.githubusercontent.com/85238036/212435918-9a4005a4-d1b7-4ca6-8474-f9549c4f1734.jpeg)


### Overview

This CRUD RESTful API is created for anyone (ideally businesses) who want to keep track of their financial expenses/transactions in a database. This API allows a person to create a table in order to store information, extract data from the tables that they create, update/modify data and delete data. This REST API was basically made as an add-on to the previous project I made (subtotal calculator). This API acts as a way to input data while the previous subtotal calculator acts as a way to modify and output data. 

### Build Process

Technologies used: Java, Spring Boot, Jakarta Persistence API, Maven, MySQL, Postman

First, I set up the project using a Spring Boot initializer and found the Maven dependencies for the Jakarta Persistence API and MySQL. Then, I created three classes: a Transaction object class, a RestAPIApplication class and a Controller class. The Transaction object class contains the columns of the table stored in the database. the RestAPIApplication class runs Spring and the Controler class performs the CRUD methods to store, update and delete the data. 

I also had to create a application properties text file which allowed me to connect to the MySQL database using a username and a password. I then used Postman in order to perform CRUD (create, read, update, delete) using a JSON file. 

### How to use

Install MySQL Workbench and create a password for the root username. Type in this password in the application.properties file. Then, go to MySQL Workbench and click the + icon to create a new connection. Fill in the information and then click "Test Connection". You should be able to enter the MySQL Workbench and see a schema on the left that says "crudtransactions". After that you should run the java class named RestApiApplication.java.

Install Postman and create a GET, POST, PUT and DELETE request that you can edit using the JSON format.

After sending a request, you can check that it worked by going to MySQL Workbench and running a query or going to a browser and typing in localhost:8080/transactions. 








