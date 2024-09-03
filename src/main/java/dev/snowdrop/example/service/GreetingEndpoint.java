package dev.snowdrop.example.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Component;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/greeting")
@Component
@Api(tags = "Greeting", description = "Endpoint relacionado con los saludos")
public class GreetingEndpoint {

    @GET
    @Produces("application/json")
    @ApiOperation(value = "Obtener un saludo", notes = "Devuelve un saludo basado en el nombre proporcionado.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Saludo generado exitosamente"),
        @ApiResponse(code = 400, message = "Parámetros inválidos")
    })
    public Greeting greeting(@QueryParam("name") @DefaultValue("Mundo") String name) {
        final String message = String.format(Greeting.FORMAT, name);
        return new Greeting(message);
    }
}
