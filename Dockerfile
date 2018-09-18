FROM openjdk:8
ADD target/myblog.jar myblog.jar
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "myblog.jar"]