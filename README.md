# Q2020


Distance Matrix API
- API_KEY value is set at the "application.properties" file.
- Unable to fully test the api since it requires an account.
- I have put in a dummy value for the API KEY at the "applicaion.properties" file, please replace them as needed.

Database
- Utilized an embedded H2 database provided by Spring Boot
- H2 database management console will go up together with the Spring Boot app via this url: "http://localhost:8081/h2-console/"
- The H2 database is configured to initalize the database upon Spring Boot start up.
- All relavant database confiuration is located at the "applciation.properties" file.

Docker
- Was not really able to implement this due to lack of time, machine resource and as well as familiarity.
- Despite of being able to create a container for the mysql image on a separate machine, I was not able to integrate it with the Spring boot app.


Executing the Spring Boot App
- At the root of the project, I use the command ./mvnw spring-boot:run to fire up the Spring Boot App.
- Once Spring Boot App has started, the following are available:
  + Rest API's
    1. For placing an order, sample curl command below:
      curl -H "Content-Type:application/json" -X POST -d '{ "origin": ["START_LATITUDE","START_LONGITUDE"],"destination":   ["END_LATITUDE","END_LONGITUDE"]}' http://localhost:8081/api/orders
      
    2. For listing the orders, see sample uri below:
      http://localhost:8081/api/orders?page=1&limit=5
      
    3. For taking an order, see sample uri below:
      http://localhost:8081/api/orders/3

  + H2 database browser console is accessible via this url: http://localhost:8081/h2-console/
    - jdbc url is "jdbc:h2:mem:testdb"
    - Credential is located at the application.properties
    
    
  Validation and eror handling
    - Applied some JaxRs built in and custom input validation for REST parameters.
    - Was not able to make custom error mapping.
  
