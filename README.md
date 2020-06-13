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

# Endpoints

```/quotes```

# HATEOAS

Run the service as follows:

```
$ java -jar hateoas/target/hateoas-1.0-SNAPSHOT.jar
```

The service runs at ```http://localhost:8081```

# Endpoints

```
/hateoas-quotes
/hateoas-quote/{id}
/hateoas-sages
/hateoas-sage/{name}
```
