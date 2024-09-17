package io.quarkiverse.jsonrpc.runtime;

import org.jboss.logging.Logger;

import com.asyncapi.v3._0_0.model.AsyncAPI;

import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class JsonRPCAsyncApiRecorder {

    private static final Logger LOGGER = Logger.getLogger(JsonRPCAsyncApiRecorder.class);

    public void storeJsonRPCMethods(AsyncAPI scanner) {
        LOGGER.debug(scanner.toString());
    }
}
