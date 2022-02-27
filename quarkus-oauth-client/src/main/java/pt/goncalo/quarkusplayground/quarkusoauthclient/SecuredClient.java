package pt.goncalo.quarkusplayground.quarkusoauthclient;

import io.quarkus.oidc.client.NamedOidcClient;
import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.Tokens;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/token")
public class SecuredClient {

    @NamedOidcClient("dsmp")
    OidcClient client;
    /**
     * This option allows to have multiple oidc clients
     * configured. This is might be handy when you want to
     * used different EAM servers.
     */
    @NamedOidcClient("dsmp")
    Tokens token;


    /**
     * Direct usage of {@link OidcClient}, this will always fetch a new token from oIdc.
     * This is for demonstration purposes only and should not be used in production systems!
     *
     * @return
     */
    @GET()
    @Path("/direct")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var token = client.getTokens().await().indefinitely();
        return token.getAccessToken();
    }

    /**
     * Relies on the oidc-filter to manage tokens for us.
     * What we get is an already valid token
     *
     * @return
     */
    @GET()
    @Path("/managed")
    @Produces(MediaType.TEXT_PLAIN)
    public String token() {
        return token.getAccessToken();
    }


}