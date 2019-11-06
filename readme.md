Create one like this
=============================

This project creates a kie-server spring-boot application with additional REST API endpoints (extensions?).

# 1. Creating the spring boot service project:

```
mvn archetype:generate -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-service-spring-boot-archetype -DarchetypeVersion=7.30.0-SNAPSHOT
```
this will launch a questionary; start by answering "No", and then continue to fill up the information to generate a project.

Note in the questionary that if you already have your kjar you can also provide the kjar information here.

# 2. Enable swagger

1. Add dependencies to pom.xml

```
<!-- SWAGGER DEPENDENCIES -->
<dependency>
  <groupId>org.webjars</groupId>
  <artifactId>swagger-ui</artifactId>
  <version>2.2.10</version>
</dependency>
<dependency>
  <groupId>org.apache.cxf</groupId>
  <artifactId>cxf-rt-rs-service-description-swagger</artifactId>
  <version>3.1.11</version>
</dependency>
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-jaxrs</artifactId>
  <version>1.5.20</version>
  <exclusions>
    <exclusion>
      <groupId>javax.ws.rs</groupId>
      <artifactId>jsr311-api</artifactId>
    </exclusion>
  </exclusions>
</dependency>

```

3. Enable swagger in the application.properties

```
kieserver.swagger.enabled=true
```

4. Access the swagger by:
- json: http://localhost:8090/rest/swagger.json
- api-docs endpoint: http://localhost:8090/rest/api-docs?url=http://localhost:8090/rest/swagger.json#/

## 2.1 Additional endpoints to swagger

### 2.1.1 Add a @Bean with swagger annotations

### 2.1.2 Add a @Bean with swagger annotations that uses the jBPM engine