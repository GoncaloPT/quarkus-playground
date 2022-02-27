# quarkus-oauth-server Project

## Goal

This project exists to both prove and showcase how a quarkus instance can support both m2m and user access token
use cases relying on quarkus oidc/oauth2 and multi tenancy.

## Creation

This project was generated using: 
`
mvn io.quarkus.platform:quarkus-maven-plugin:2.7.1.Final:create \
-DprojectGroupId=pt.goncalo.quarkus-playground \
-DprojectArtifactId=quarkus-oauth-server \
-DclassName="pt.goncalo.quarkusplayground.quarkusoauthserver.SecuredResource" \
-Dextensions="resteasy,resteasy-jackson,security-oauth2"
`

It can be used has a resource server that uses an external oauth IdP. 

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more
- Multi-tenancy https://quarkus.io/guides/security-openid-connect-multitenancy
