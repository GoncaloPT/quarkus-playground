# Quarkus playground

For all quarkus related playground projects.
Quarkus version should be setup in the parent pom

## Projects

Here you can find a list of the projects present in this folder:

1. quarkus-oauth-client
client credentials flow, to tryout the usage of quarkus extensions to acquire and refresh access tokens from authorization server

1. quarkus-oauth-server
This is actually a oauth 'client' but it will serve the role of server, or basically the service that owns the resource.

mvn archtype used to generate:
`
mvn io.quarkus.platform:quarkus-maven-plugin:2.7.1.Final:create \
-DprojectGroupId=pt.goncalo.quarkus-playground \
-DprojectArtifactId=quarkus-oauth-server \
-DclassName="pt.goncalo.quarkusplayground.quarkusoauthserver.SecuredResource" \
-Dextensions="resteasy,resteasy-jackson,security-oauth2"
`
## Use cases

Bellow there are listed the use cases for the created projects and the explanation of the goal of which

### m2m authentication using quarkus 

By using quarkus-oauth-client ( resource client ) and quarkus-oauth-server one can fully test the implementation 
suggestion for a quarkus based m2m communication flow, secured using oidc.

#### Run the POC

In order to run the poc, configuration of the oidc provider must be set. 
You can do so by setting the required environment variables:
- DSMP_AUTH_SERVER_URL
- DSMP_AUTH_CLIENT_ID
- DSMP_AUTH_CLIENT_SECRET
- DSMP_AUTH_SCOPES

Then, you can use the docker-compose file present in ./docker folder:
`docker-compose up -f m2m-oidc-compose.yml`


