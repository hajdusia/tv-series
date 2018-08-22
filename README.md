### Overview
TV series application provides data about TV series such as genre, average review, number of seasons, list of episodes with title and premiere date.
It also allows to give a grade for specific TV series.

### Technologies used
- Spring Boot
- Lombok
- Gradle
- Docker

### Available operations
- Listing all TV series
- Listing TV series by genre
- Getting TV series by name
- Getting average rating for TV series
- Adding new rating for TV series

### Running application
You can easily build and run a Docker image using commands:

```
./gradlew build docker
docker run -p 8080:8080 -t pl.hajduk.anna/tv-series
```

When the application starts, you can use Swagger (localhost:8080/swagger) to test it manually.

### Running unit tests
You can run unit tests with Gradle:

```
./gradlew test
```

### Assumptions and caveats
- Database is mocked with use of Java collections.
- Database access is synchronised only for `reviews` collection. 
This is the only collection that can potentially change based on user input.
- Only happy paths are covered - there is no validation of user input.
- TVSeries expose too much details via API (list of ratings instead of average).

