Steps

--------selenium tests-------------------
The pom.xml file is in the flights folders(this is the project name created in maven), this file is ready for CI, 
I conducted this in Maven and used Jenkins to do the build for CI.
There is a jenkins report in the Git Folder to show the successful test.

Clone the project from Git,
If you open the project in eclipse and copy these files to a folder on your local drive you will be able to run a test in command line or Bash script. The automaion will run in the browser in this case i used a chrome browser.
Note these are Maven tests.

To note: you might have to add the google web driver to your local drive and add it into the project in eclipse. But it wont be necessary as the pom.xml will cover this process.
The site used for the test is called: www.expedia.com

To get the jar files selenium, testng you can refer to this site:
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
https://mvnrepository.com/artifact/org.testng/testng














