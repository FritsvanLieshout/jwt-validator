# JWT Validator
This project is a library for verifying JWT. 


## Maven
````XML
<dependency>
    <groupId>io.github.fritsvanlieshout</groupId>
    <artifactId>jwt-validator</artifactId>
    <version>0.0.1</version>
</dependency>
````


## Java
````java
String[] roles = this.authorizationFilter.verify("SECRET", "JWT");
````
