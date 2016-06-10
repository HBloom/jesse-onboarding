A very simple web app that returns all possible combinations of the coin denominations that add up to the total amount.

The tech stack inherits from the HBloom POM and can be run using spring-boot.

The server takes a very simple post request with three params (totalAmount, coinNames, and coinValues) and gives you back a response with all the possible combinations.

Front-end is just a very basic HTML/JS/jQuery app without any styling that prints out the response.

Lots of improvements could be made, but goal of the app was to become more familiar with Maven & Spring which I feel was accomplished.

To run the app

```
mvn compile && mvn spring-boot:run
```

or
```
mvn package && mvn spring-boot:run
```

just depending on how you want maven to build it.
