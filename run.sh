mvn clean install -DskipTests -o

java -jar D:\newspaperbe\target\news-0.0.1-SNAPSHOT.jar
java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005  D:\newspaperbe\target\news-0.0.1-SNAPSHOT.jar