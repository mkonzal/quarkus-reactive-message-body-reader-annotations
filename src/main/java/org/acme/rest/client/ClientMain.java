package org.acme.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;

@Path("remote-service/test")
@RegisterRestClient(configKey = "test-api")
@RegisterProvider(DoubleQuoteReader.class)
@RegisterProvider(SingleQuoteReader.class)
public interface ClientMain {
    @GET
    @Produces("text/plain")
    @MainResource
    Uni<String> test();

    @Path("{id}/sub")
    ClientSub sub(@PathParam("id") String id);
}
