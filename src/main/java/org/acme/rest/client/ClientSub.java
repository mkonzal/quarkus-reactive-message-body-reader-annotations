package org.acme.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import io.smallrye.mutiny.Uni;

public interface ClientSub {
    @GET
    @Produces("text/plain")
    Uni<String> test();
}
