# MyBlog Micro Service

## About

This is blog page Micro Service, Every authenticated user can add new blog posts, update, get and delete the blog post . Non-authenticated users can not access this services.

It was made using **Spring Boot**, **Spring Data JPA**, **Spring Data REST** and **Docker**.
Database is in memory **MongoDB**.


## Configuration

### Configuration Files

Folder **src/resources/** contains config files for **MyBlog** Spring Boot application.

* **src/resources/application.properties** - main configuration file. Here it is possible to change the port number.

## How to run

There are several ways to run the application. You can run it from the command line with included Maven Wrapper, Maven or Docker.

Once the app starts, go to the web browser and visit `http://localhost:9001/`

### Maven Wrapper

#### Using the Maven Plugin

Go to the root folder of the application and type:
```bash
$ chmod +x scripts/mvnw
$ scripts/mvnw spring-boot:run
```

#### Using Executable Jar

Or you can build the JAR file with
```bash
$ scripts/mvnw clean package
```

Then you can run the JAR file:
```bash
$ java -jar target/MyBlog-0.0.1-SNAPSHOT.jar
```

### Maven

Open a terminal and run the following commands to ensure that you have valid versions of Java and Maven installed:

```bash
$ java -version
java version "1.8.0_102"
Java(TM) SE Runtime Environment (build 1.8.0_102-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14, mixed mode)
```

```bash
$ mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_102, vendor: Oracle Corporation
```

#### Using the Maven Plugin

The Spring Boot Maven plugin includes a run goal that can be used to quickly compile and run your application.
Applications run in an exploded form, as they do in your IDE.
The following example shows a typical Maven command to run a Spring Boot application:

```bash
$ mvn spring-boot:run
```

#### Using Executable Jar

To create an executable jar run:

```bash
$ mvn clean package
```

To run that application, use the java -jar command, as follows:

```bash
$ java -jar target/MyBlog-0.0.1-SNAPSHOT.jar
```

To exit the application, press **ctrl-c**.

### Docker

It is possible to run **MyBlog** using Docker:

Build Docker image:
```bash
$ mvn clean package
$ docker build -t MyBlog:dev -f docker/Dockerfile .
```

Run Docker container:
```bash
$ docker run --rm -i -p 9001:9001 \
      --name MyBlog \
      MyBlog:dev
```

##### Helper script

It is possible to run all of the above with helper script:

```bash
$ chmod +x scripts/run_docker.sh
$ scripts/run_docker.sh
```

## Docker

Folder **docker** contains:

* **docker/MyBlog/Dockerfile** - Docker build file for executing MyBlog Docker image.
Instructions to build artifacts, copy build artifacts to docker image and then run app on proper port with proper configuration file.

## Util Scripts

* **scripts/run_docker.sh.sh** - util script for running MyBlog Docker container using **docker/Dockerfile**

## Tests

Tests can be run by executing following command from the root of the project:

```bash
$ mvn test
```

In `/src/main/resources/application.properties` file it is possible to change both
web interface url path, as well as the datasource url.

Quick start
-----------
1. `mvn package`
2. `java -jar target/epayments-0.0.1-SNAPSHOT.jar`
3. `use post man to test the below API's `
4. `Authentication using a X-Auth-Token header for REST APIs`
5. `base path http://localhost:8080`

Steps to Generate X-Auth-Token Header Value
--------------------------------------------
Step 1. `use this API /createUserSession to generate the user session`
Step 2. `once created the user session,  get the sessionId from created session and add to the X-Auth-Token header vlaue`
Step 3. `X-Auth-Token: 123456`

## Resources

  Method  | Path                   |reqest Header                                      |     request payload                        
|-------- |----------------------- |---------------------------------------------------|------------------------------------------------------------------------------  |
| POST    | /createUserSession/    | Content-Type:application/json                     | {"customerId": "cust2","clientId":"client", "clientSecret":" hello world"} |                     
| POST    | /createNewPost/          | X-Auth-Token: 123456,Content-Type:application/json| {   "postId": null, "title": "Learn TypeScript in 5 minutes",        "body": "Learn TypeScript in 5 minutes", "createDate": 1537196949706, "status": "Active", "userId": "kamahalingam", "commentId": [] }|                     
| GET    | /getPost       | X-Auth-Token: 123456,Content-Type:application/json| ?postId=ALL|
| PUT    | /updatePost/ | X-Auth-Token: 123456,Content-Type:application/json| {   "postId": null, "title": "Learn TypeScript in 5 minutes",        "body": "Learn TypeScript in 5 minutes", "createDate": 1537196949706, "status": "Active", "userId": "kamahalingam", "commentId": [] }|
| DELETE    | /deletePost     | X-Auth-Token: 123456,Content-Type:application/json|?postId=12345|

## Sequence Diagram

![createUserSession](https://github.com/kalidassmk/MyBLOG/blob/master/design/createUserSession.png)
![createNewPost](https://github.com/kalidassmk/MyBLOG/blob/master/design/createNewPost.png)
![getPost](https://github.com/kalidassmk/MyBLOG/blob/master/design/getPost.png)
![updatePost](https://github.com/kalidassmk/MyBLOG/blob/master/design/updatePost.png)
![delete](https://github.com/kalidassmk/MyBLOG/blob/master/design/delete.png)

