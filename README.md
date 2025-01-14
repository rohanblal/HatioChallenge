# HatioChallenge
A Spring Boot application integrating with a public API to provide real-tim currency exchange rates
_____________________________________________________________________
Technologies used: Java 17,Spring Boot, Maven, REST API, JUnit for testing  
Install Java 17 or higher version. Preferably use Eclipse IDE. Internet access is required throughout.
_____________________________________________________________________
Contents  
src/main/java: CurrencyConvertor.java, CurrencyConvertorController.java, CurrencyService.java, CurrencyResponse.java  
src/main/resources: application.properties  
src/testing/java: Testing.java  
_____________________________________________________________________
Dependencies used:  
~Spring Boot Web(For building REST APIs)  
~Spring Boot Validation(For request validation)  
~JSON Processing(Jackson library)  
~Spring Boot Test(For unit tesing)  
~JUnit  
~JUnit 5(for unit testing)
_____________________________________________________________________
Instructions  
1.Copy the files from repository and save accordingly onto a Maven Project  
2.Open "application.properties" file and update your API key from ExchangeRate-API in "currency.api.url="  
3.Use Maven to run the project
4.Using browser or Postman app, we can fetch exchange rates and convert currency  
  -Fetch exchange rates: http://localhost:8086/api/rates?base=USD  
  -Convert currency: http://localhost:8086/convert?from=USD&to=EUR&amount=100  
_____________________________________________________________________  
Running Tests from Eclipse:  
Right-click on the src/test/java folder or a specific test class.  
Select Run As > JUnit Test to run the tests.
