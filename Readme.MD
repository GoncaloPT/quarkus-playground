# Quarkus playground

For all quarkus related playground projects.

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
- DEFAULT_AUTH_SERVER_URL
- DEFAULT_AUTH_CLIENT_ID
- DEFAULT_AUTH_CLIENT_SECRET
- DEFAULT_AUTH_SCOPES
- M2M_AUTH_SERVER_URL
- M2M_AUTH_CLIENT_ID
- M2M_AUTH_CLIENT_SECRET
- M2M_AUTH_SCOPES

**note:**  default in this context means client flow ( the one opposed to m2m )  
**note2:** while developing this example, i've used a .sh script that sets all the required env variables. For security reasons the file is not included in this repo; but you can use the same approach. '*set-\**-variables.sh' pattern was added to .gitignore.


Then, you can use the docker-compose file present in ./docker folder:
`docker-compose -f m2m-oidc-compose.yml up `

The example client will fetch a valid token from the defined oidc provider and do a get request 
to oauth-server. oauth-server will then validate the token and respond accordingly.


