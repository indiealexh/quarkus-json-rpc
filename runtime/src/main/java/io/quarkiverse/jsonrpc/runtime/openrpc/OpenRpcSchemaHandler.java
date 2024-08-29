package io.quarkiverse.jsonrpc.runtime.openrpc;

import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class OpenRpcSchemaHandler implements Handler<RoutingContext> {
    private static final String ALLOWED_METHODS = "GET, OPTIONS";
    private static final String CONTENT_TYPE = "application/json; charset=UTF-8";

    //private final SchemaPrinter schemaPrinter;

    public OpenRpcSchemaHandler() {
        //this.schemaPrinter = new SchemaPrinter();
    }

    @Override
    public void handle(RoutingContext event) {
        HttpServerRequest request = event.request();
        HttpServerResponse response = event.response();

        //TODO: Make this real
        String schemaString = """
                {
                  "error": "Unable to generate OpenRPC schema"
                }
                """;

        //OpenRpc openRpcSchema = CDI.current().select(OpenRpc.class).get();
        //String schemaString = schemaPrinter.print(openRpcSchema);

        if (request.method().equals(HttpMethod.OPTIONS)) {
            response.headers().set(HttpHeaders.ALLOW, ALLOWED_METHODS);
        } else if (request.method().equals(HttpMethod.GET)) {
            response.headers().set(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE);
            response.end(Buffer.buffer(schemaString));
        } else {
            response.setStatusCode(405).end();
        }
    }
}
