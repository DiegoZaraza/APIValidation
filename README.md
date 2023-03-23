# API Automation 
Project designed for the automation of the API [https://automationexercise.com/api/productsList](https://automationexercise.com/api/productsList)

### What you’ll need
+ A favorite text editor or IDE
+ JDK 8 or later
+ Install mvn [MAVEN](https://github.com/apache/maven/blob/master/apache-maven/README.txt)

## Get the code

Git:

    Whit SSH
    git clone git@github.com:DiegoZaraza/APIValidation.git
    cd BlankFactor
    
    With HTTPS
    git clone git@github.com:DiegoZaraza/APIValidation.git
    cd BlankFactor
    
Or simply [download a zip](https://github.com/DiegoZaraza/APIValidation/archive/refs/heads/main.zip) file

## Execution
For execute the project you must use:
    
    mvn clean test
    
# Questions

a. What would be the desired value for the API response time?

The desired value for the API response time will depend on the use of the transaction since it is not the same to respond to a specific query for a single record as it is to respond to several records. I think that the response time should be less than 1000 ms.

b. Is latency an important indicator when performing this type of testing? If the request takes a long time to reach the server, how do you communicate this to the BE team?

Latency is an important indicator when performing API testing as it directly affects the user experience. If there is a considerable delay for the request to reach the server this is reflected in what the end user is doing. In this case it is important to communicate to the BE team by creating a ticket so that this issue is worked on as a priority since it directly affects the user and can cause them to stop using the resources due to delays.

c. Should this feature/endpoint include a distributed load test? If so, what tools will you use and what will the scenario be? what will the scenario be?

It is always good to include this type of distributed load testing for an endpoint/feature to ensure scalability and robustness.

As a main scenario we should simulate the load of a number of users accessing the system at the same time where we can define the number of users according to the technical specifications of the system and taking into account the volume for which it is contemplated, so we can measure the response time, the error rate that can have for the number of users.

As a tool you can use jmeter, gatling where you can simulate this high number of requests to the system.

Translated with www.DeepL.com/Translator (free version)