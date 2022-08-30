# Drone Transport
There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.
application base url [ localhost:8080/api ]

# Requirements
***For building and running the application you need:***
- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html#license-lightbox)
- [Apache Maven 3.8.4](https://maven.apache.org)

# Technology
***Technologies used in the project***
- Spring-boot 2.7.3
- Java 11
- Maven 3.8.4
- H2 in memory Database
- Swagger UI
- Actuator

# Build Project
Inside project folder get the ***CMD*** and execute command ***mvn clean install***

After successful build run the application using ***mvn spring-boot:run*** command 

#H2 Database configuration
http://localhost:8080/api/h2 URL through you can access the console of H2 database.
Please see the application.properties file for getting database configuration values

JDBC URL: jdbc:h2:mem:droneTransportDb
username: admin
no password required

#API documentation
http://localhost:8080/api/swagger-ui.html URL through you can check the API documentation

#Application level properties
Set this property to configure minimum drone loading battery capacity : drone.transport.battery.percentage.min
Set this property to configure logs write to DB or File : drone.transport.battery.check.schedule.logging [DB/FILE]
Set Periodic execution time for use this property : drone.transport.battery.check.schedule

Periodic checking battery log file can be found in this location [/log/battery-history.log]
Application logs file can be found in this location [/log/drone-transport.log]

You can check the application health using **localhost:8081/actuator/health** URL

# Notes
***While you start the application initial data will be inserted in to the relevant tables***

#Assumptions
- When creating a drone battery capacity is 0
- Users after register the drone then only update the drone battery capacity
- Drone can be load only once
