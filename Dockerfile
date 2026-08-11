FROM maven:3.9.16-eclipse-temurin-21 As build

WORKDIR /gym

COPY . .

RUN mvn clean package -DskipTest

#segunda etapa

FROM eclipse-temurin:21-jre

WORKDIR /gym

COPY --from=build /gym/target/*.jar gym.jar

EXPOSE 8080

CMD["java","-jar","gym.jar"]
