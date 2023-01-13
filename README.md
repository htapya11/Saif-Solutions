# Saif Solutions Internship

## Subtotal Calculator

### Overview

Technologies Used: Java. Maven, JavaMail API

This subtotal calculator is made for anyone (ideally small business owners) who want to keep track of their expenses. This calculator reads in a CSV file containing transactions from throughout a time period, modifies this data so that it groups and adds all similar transaction amounts and then automatically sends this updataed data in an new attached CSV file via email. This makes it easier for the user to understand which categories of their expenses can be cut down and can help them get a better understanding of how to appropriately budget their money.

### Improvements

At first, I opted to store the original data in a HashMap instead of an ArrayList of objects. While this original method was faster, the code was much cleaner and easier to understand when I re-wrote it using an ArrayList of objects. Ultimately, by re-writing the code using an ArrayList of objects instead of a HashMap I sacrificed speed for readability and making it easier to scale and refactor in the future.


