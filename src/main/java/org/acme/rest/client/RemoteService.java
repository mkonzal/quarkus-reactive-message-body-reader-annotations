package org.acme.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;

@Path("/remote-service")
public class RemoteService {
    @RestClient
    ClientMain remoteService;

    @GET
    @Path("test")
    @Produces("text/plain")
    public Uni<String> testMain() {
        return Uni.createFrom().item("main");
    }

    @GET
    @Path("test/{id}/sub")
    @Produces("text/plain")
    public Uni<String> testSub(final String id) {
        return Uni.createFrom().item("sub " + id);
    }
}
