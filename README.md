# Saif Solutions Internship

## Subtotal Calculator

Calculates subtotals from a file containing financial transactions


Before
![Expenses](https://user-images.githubusercontent.com/85238036/212371938-7aa764fb-d55d-47e6-bb95-0763257f17ed.jpeg)

After
![New Note](https://user-images.githubusercontent.com/85238036/212372106-5c9122d5-2f0e-4663-aca0-9e1774f548a6.jpeg)


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


