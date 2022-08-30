# Drone Transport
There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

# Requirements
***For building and running the application you need:***
- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html#license-lightbox)
- [Apache Maven 3.8.4](https://maven.apache.org)

# Technology
***Project for used technologies***
- [Spring-boot 2.7.3]
- [Java 11]
- [Maven 3.8.4]
- [H2 in memory Database]
- [Swagger UI]

# Build Project
Inside project folder get the ***CMD*** and execute command ***mvn clean install***
after successfully build run the application using ***mvn spring-boot:run*** command (type in CMD) 

#H2 Database configuration
http://localhost:8080/api/h2 URL through you can access the console of H2 database.
Please see the application.properties file for getting database configuration values

#API documentation
http://localhost:8080/api/swagger-ui.html URL through you can check the API documentation

# Notes
***While you start the application initial data insert to the relevant tables***