package pt.goncalo.quarkusplayground.quarkusoauthclient;

import io.quarkus.oidc.client.NamedOidcClient;
import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.Tokens;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Path("/service-b-client")
public class ServiceBClient {
    @NamedOidcClient("dsmp")
    Tokens token;

    /**
     * Direct usage of {@link OidcClient}, this will always fetch a new token from oIdc.
     * This is for demonstration purposes only and should not be used in production systems!
     *
     * to call it:
     * curl -i http://localhost:8090/service-b-client/direct
     *
     * @return
     */
    @GET()
    @Path("/direct")
    @Produces(MediaType.TEXT_PLAIN)

    public String callHello() throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder().build();
        var request = HttpRequest
                .newBuilder(URI.create("http://localhost:8080/m2m/hello"))
                .setHeader("Authorization", "Bearer " + token.getAccessToken())
                .GET()
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }


}
