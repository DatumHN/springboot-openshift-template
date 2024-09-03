package dev.snowdrop.example.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import org.springframework.stereotype.Component;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/greeting")
@Component
public class GreetingEndpoint {

    @GET
    @Produces("application/json")
    @ApiOperation(tags = "Greeting", value = "Endpoint relacionado con los saludos", notes = "Servicio para obtener un saludo basado en un nombre ingresado.")
    @ApiResponse(code = 200, message = "{\"content\":\"Hola, Mundo!\"}")
    
    public Greeting greeting(@QueryParam("name") @DefaultValue("Mundo") String name) {
        final String message = String.format(Greeting.FORMAT, name);
        return new Greeting(message);
    }
}
