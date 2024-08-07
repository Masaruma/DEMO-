- Logging levels
```text
ERROR, WARN, INFO, DEBUG, TRACE, ALL

ROOT.LEVEL = WARN -- > ERROR & WARN
ROOT.LEVEL = DEBUG --> ERROR, WARN, INFO & DEBUG

log -> log.error("") 
log.debug("")
log.info("")

```


- Write a full e2e integration test in TDD for a new API
  /api/v1.....
- save data
- retrieve data


Write a spring boot application that calls an external api and saves it to database
https://jsonplaceholder.org

POST /api/posts
GET /api/posts

Spring Boot with H2

GET /api/v1/posts - Controller -> Service -> JsonPlaceholder /api/posts and display it on the console
POST /api/v1/posts - Controller -> Service -> Jsonplaceholder /api/post POST

RestClient - POST, GET client /api/v1/post of JsonPlaceholder

Repository == JsonPlaceHolderService

Controller -> Service -> JsonPlaceHolderService

start.spring.io - Spring web
RestClient -> JSON placeholder service



