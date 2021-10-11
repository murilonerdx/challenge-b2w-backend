# challeng-backend-1
Is a Spring Boot based application exposing a REST API to get orders 
filters by data.

## Tech stack
The application is based on the following projects:

* **Spring boot** 2.5.5
* **Mockito** 3.8.0
* **Maven** 3.8.1
* **Project Lombok** 1.18.20
* **Java** 11

## How To Run Locally
* Run the backend application. Make sure you have Java and Maven installed.
----
* $ git clone https://github.com/murilonerdx/challenge-backend  <1>
* $ cd challenge-backend <2>
* $ mvn spring-boot:run <3>
----
Your app should now be running on [localhost:8080](http://localhost:8080/).
Gracefully shutdown hit `ctrl+c`.

## How to Call Endpoints
`$ http GET:8080/challenge-backend/item?begindate=dd-MM-yyyy&finaldate=dd-MM-yyyy`
