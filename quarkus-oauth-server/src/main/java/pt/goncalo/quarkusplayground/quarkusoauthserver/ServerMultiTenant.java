package pt.goncalo.quarkusplayground.quarkusoauthserver;

import io.quarkus.oidc.TenantResolver;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServerMultiTenant implements TenantResolver {
    private static final String m2m_path = "m2m";
    private static final String m2m_tenant_name = "m2m";
    // according to the spec, null is the expected value when you don't want to specify any tenant
    private static final String default_tenant_name = null;

    @Override
    public String resolve(RoutingContext context) {
        final var uri = context.request().uri();
        if (uri.contains(m2m_path)) {
            return m2m_tenant_name;
        }
        return default_tenant_name;
    }
}
