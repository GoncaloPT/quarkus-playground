package pt.goncalo.quarkusplayground.quarkusoauthclient;

import io.quarkus.oidc.client.NamedOidcClient;
import io.quarkus.oidc.client.Tokens;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.control.ActivateRequestContext;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@QuarkusMain
@ActivateRequestContext
public class M2mTestCommand implements QuarkusApplication {



    @NamedOidcClient("dsmp")
    Tokens token;
    @ConfigProperty(name= "oauth-client.server.url")
    String clientEndpointUrl;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("******************************************************************");
        System.out.println("*       STARTING " + M2mTestCommand.class.getName() + "          * ");
        var httpClient = HttpClient.newBuilder().build();
        var request = HttpRequest
                .newBuilder(URI.create(clientEndpointUrl))
                .setHeader("Authorization", "Bearer " + token.getAccessToken())
                .GET()
                .build();
        System.out.printf("* About to send GET request to %s           *%n", clientEndpointUrl);

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.printf("* response status is %s *", response.statusCode());
        if(response.statusCode() == 200){
            System.out.printf("* response body :  %s *", response.body());
        }
        System.out.println("******************************************************************");
        return 0;
    }
}
