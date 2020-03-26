# Q2020


Distance Matrix API
- API_KEY value is set at the application.properties
- Unable to fully test the api since it requires an account.
- Just put in a dummy value for the API KEY in the applicaion.properties, please replace them as needed.

Database
- Utilize an embedded H2 database provided by Spring Boot
- H2 database console can will go up together with the Spring Boot app via this url: http://localhost:8081/h2-console/
- The H2 database is configured to initalize the database upon Spring Boot start up.
- All relavant database confiuration is on the applciation.properties.

Docker
- Was not really able to implement this due to lack of time and resource and as well as familiarity.
- Despite of being able to create a container for the mysql image on a separate machine, I was not able to integrate it with the Spring boot app.


Executing the Spring Boot App
- I use the command 
