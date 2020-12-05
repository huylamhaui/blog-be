FROM maven:3.6.3-openjdk-8 as build-jar

WORKDIR /opt/blog-be

COPY . .

RUN mvn clean package -DskipTests



FROM openjdk

WORKDIR /opt/blog-be

COPY --from=build-jar /opt/blog-be/target/*.jar .

CMD [ "java", "-jar", "blog-be.jar" ]