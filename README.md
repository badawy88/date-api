## To RUN the application run the below command
####
java -jar date-api-0.0.1-SNAPSHOT.jar
####

## To STOP the application run the below command
####
curl -X POST http://localhost:9091/actuator/shutdown
####

## To CHECK service status,  the application run the below command
####
curl -X GET http://localhost:9091/actuator/health
####
