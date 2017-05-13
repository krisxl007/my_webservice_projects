Base on JDK8, this web service maven project integrated with Spring, Spring Security, Hibernate, ActiveMQ and Mysql:

1. Start up your local Mysql database and configure your database details in hibernate.cfg.xml

2. Start up you local ActiveMQ

3. Run Jetty plugin to start server with maven command: mvn jetty:run

4. Restful API as below urls with login username and password:
   1)push(POST method): http://localhost:8080/webapi/element/values
   2)list(GET method): http://localhost:8080/webapi/element/list

   username1: admin
   password1: admin

   username2: user
   password2: user
