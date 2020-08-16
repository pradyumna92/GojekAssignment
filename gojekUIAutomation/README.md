# Gojek UI Automation

### Project Description:
This project illustrates Selenium framework with TestNG using Page object Module Design Pattern to validate scenarios on Successful and Failed Credit Card Transaction.
Implemented both positive and Negative scenario which reads data from config file.

Pure Java project that uses maven as build tool to manage dependencies and execution. TestNG has been used to handle parameterization and showcase report. It also depicts basic reporting using 'extentreports'.


### Pre-Requisite:
*Project have been run on windows 10 platform with JDK 1.8. Please ensure JDK 1.8(64 bit) is installed and configure jdk 1.8 if compilation fails.*

### Project/Test Details & ThoughtProcess:
Selenium(3.141.59) is used to automate gojek Ui Automation flow which was expected to be run on Chrome and FireFoc driver. Page Object design pattern is implemented and all the webelements identified are stored in the pageobject class created .For which data is stored in config file. 
 
### Test Scenarios:
1.	successCreditCardPayment.java : Tests the successful credit card transactions when valid credit card number is entered.
2.	failedCreditCardPayment.java : Tests the failed credit card transactions when incorrect credit card number is entered.


### Package Information:
 
* _com.gojek.ui.base.service_ : commonMethods.java class which has page functions(methods) which would be used throughout the credit card transaction process.
* _com.gojek.ui.pageObjects_ : Webelements identified for the landingpage and the corresponding page functions are mentioned
* _com.gojek.ui.utilities_ :Contains class file to initiate the WebDriver 
* _com.gojek.ui.testSuites_ : Classes with testng tests as described above.
* _src/test/resources_ : Contains drivers and properties file.

### Steps to build/Run:
Run as Maven Build

clean install -Dbrowsername=chrome -Dgroups=positive

Valid values are :
*	Browser : chrome,firefox
*	Groups : positive,negative,regression


### Reporting:
Upon successful project execution reports can be viewed as below:
1.	Target/surefire-reports/emailable-report.html
2.	Target/surefire-reports/extent.html
 

### Jars Used:
* Selenium
* TestNG
* Maven
* extentreports
