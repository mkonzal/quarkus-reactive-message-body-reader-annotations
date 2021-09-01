package org.acme.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;

@Path("/service")
public class Service {
    @RestClient
    ClientMain remoteService;

    @GET
    @Path("/main")
    @Produces("text/plain")
    public Uni<String> testMain() {
        return remoteService.test();
    }

    @GET
    @Path("/sub/{id}")
    @Produces("text/plain")
    public Uni<String> testSub(final String id) {
        return remoteService.sub(id).test();
    }
}
