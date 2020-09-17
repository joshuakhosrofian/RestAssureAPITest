# API Testing automation framework for RESTful Services

## Framework structure
## Dependencies
This api automation frameowrk depends on following external libraries
```xml
<dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>4.3.1</version>
</dependency> 

<dependency>
       <groupId>org.testng</groupId>
       <artifactId>testng</artifactId>
       <version>6.14.3</version>
</dependency>
```
### Framework Architectural Diagram
```
|-pom.xml                   # project object model file for the maven software
|-testng.xml                # TestNG configuration files for the test structures and groupings
|-src
    |---test
        |----java           # all the java source files needs to be stored in this folder
            |-[+]testcase   # java class package, all test class will be stored here
            |-[+]utility    # java class package, all the utility class will be stored here
            |-[+]commons    # java class package, all the commons class will be stored here
        |----resources      # resources folder, json files, xml files, excel files and reports
            |-[d]json       # all the json files used in tests are stored here
            |-[d]xml        # all the xml files used in tests are stored here
            |-[d]reports    # all the reports generate by test execution are stored here
|-gitignore                 # git ignore config file
|-README.md                 # you are currently viewing this file
```

## Pre-requisites
* Download and install Chrome or Firefox Browser ( viewing report )
* Download and install JDK v1.8 +
* Download and install Apache Maven v3.0+
* Download and install Git v.20+

## Set-Up Instructions

## How to write Test Cases

## How to run Tests
All the test triggering it done through maven commands, this framework supports multiple different types of
test executions such as smoke, regression, and end-to-end on different possible environment such as QA, Staging, and
UAT. 
#### Executing specific tests
If you would like to execute a specific test that are stated on testng.xml file
```shell script
mvn test -Dtestof="smoke_api"
``` 

If you would like to execute all of the tests that are stated on testng.xml file
```shell script
mvn test
```

If you would like to execute multiple different types of tests stated on testng.xml file
```shell script
mvn test -Dtestof="test1", "test2", "test3"
```

If you would liek to execute a specific test on specific environment ( default=UAT )
```shell script
mvn test -Dtestof="test1" -Denv"Staging"
```

## How to get Report
