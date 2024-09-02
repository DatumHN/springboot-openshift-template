package dev.snowdrop.example.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

@Path("/greeting")
@Component
public class GreetingEndpoint {
    @GET
    @Produces("application/json")
    public Greeting greeting(@QueryParam("name") @DefaultValue("Mundo") String name) {
        final String message = String.format(Greeting.FORMAT, name);
        return new Greeting(message);
    }
}
