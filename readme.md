//--------------------------------------------- Database
1- Run mongodb on this port : 27017
2- Import assignment script

//--------------------------------------------- Application
After maven install the following projects:
1- crossover_books
2- crossover_profile
3- crossover_web

if you want run these application outside eclipse then copy jars from tagert folder, 
then in order to run them do the following:
open cmd or shall then navigate into your directory then run the following commands into separte cmd screen so total screens will be three:

1- java -jar crossover_books-0.0.1-SNAPSHOT.jar
2- java -jar profile-0.0.1-SNAPSHOT.jar
3- java -jar web-0.0.1-SNAPSHOT.jar

Then open browser and type : http://localhost:8080/library

if you want open swagger URL's for web services:

1- Profile : http://localhost:8082/swagger-ui.html
1- Books : http://localhost:8081/swagger-ui.html