# Spring Boot & REST

# SE-457: Service Oriented Architecture

## Research Project

Build all of the web services at once as follows:
```
$ mnv clean package
```

# Caching

Run the service as follows:
```
$ javat -jar caching/target/caching-1.0-SNAPSHOT.jar
```

The service runs at ```http://localhost:8080```

## Endpoints

```/quotes```

# HATEOAS

Run the service as follows:

```
$ java -jar hateoas/target/hateoas-1.0-SNAPSHOT.jar
```

The service runs at ```http://localhost:8081```

## Endpoints

This web service needs a local MongoDB server. The connection credentials can be configured in the ```application.yml``` configuration file.
Collections needed:

```
quotes - List of quotes to initialize the MongoDB collection is provided in repository/QuoteLoader.java
sages - List of sages to initialize the MongoDB collection is provided in repository/SageLoader.java
```

```
/hateoas-quotes
/hateoas-quote/{id}
/hateoas-sages
/hateoas-sage/{name}
```
# Reactive Web Service

Run the service as follows:

```
$ java -jar hateoas/target/reactive-1.0-SNAPSHOT.jar
```

The service runs at ```http://localhost:8082```

## Endpoints

```
/quote-flux
/quote-mono/{id}
/rsvp-flux
```
The ```/rsvp``` endpoint calls an API from the Meetup endpoint ```http://stream.meetup.com/2/rsvps``` 
and transforms the JSON objects into objects of custom defined type RSVP.

The Meetup endpoint emits a stream of responses, which the WebClient receives with two backpressures:

```
    .take(20)
    .take(Duration.ofSeconds(10));
```

The first one limits the number of responses to 20, and the second one limits the duration of the connection to 10 seconds.
Whichever happens first will cause the stream to end.