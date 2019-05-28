# assignment : To verify the login functionality of the url: : https://www.saucedemo.com/index.html
Exercise 1: Created Manual testcases and uploaded in the Github repository (SauceDemo.txt)

Exercise 2: Created a Maven project and added relevant dependencies in pom.xml.   
Added packages for BaseClass, PageObjects, TestCases, Utilites, Testdata.  
Added Folders for Configuration, Drivers and Screenshots.  
Added log4j.properties file and created TestNG.xml.  
Added all constant values like baseURL, driverpath, username and password in config.properties file.   
Read these data using ReadConfig.java which is placed in Utilites package.   
Utilites package also contains XLUtils for data driven testing and Reporting for extent reports.   
Screenshots folder contains screenshots of failed tests.    
Test Reports are generated in html format under test-output folder.    
Logs are available under log folder.    
Automated 5 testcases (TC_001, TC_002, TC_005,TC_006,TC_008) for positive and negative testing of Login feature.   
Ran testsuites in TestNG.xml and pom.xml in local system.   
Open GIT Bash Here in the workspace location (SauceDemo).   
Executed following commands to attach the files in github repo:    
   git init     
   git remote add origin "https://github.com/jeetoSandhu/SauceDemo"     
   git status       
   git add -A        
   git commit -m "Added TC_001, TC_002, TC_005,TC_006,TC_008"      
   git status shown: On branch master          
    nothing to commit, working tree clean

Eclipse Setup:
- Download the project from git repository to your local machine
- In Eclispe, go to File > Open Projects from File System
- Browse to the local repo and select "Finish"
- Refresh the project or do a clean Maven build
- Run the project as specified in line number 15 above. 
