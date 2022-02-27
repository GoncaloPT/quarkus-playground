package pt.goncalo.quarkusplayground.quarkusoauthserver;

import io.quarkus.security.Authenticated;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Represents a secured resource that can reached in 2 endpoints:
 * - one will use client flow
 * - other will use m2m flow
 */
@Path("/{a:hello|m2m/hello}")
public class SecuredResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Authenticated
    public String hello() {
        return "Hello from quarkus-oauth-server";
    }
}
