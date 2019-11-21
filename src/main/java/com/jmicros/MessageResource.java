package com.jmicros;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path("/supply-chain-api/rest/supply_chain")
@Produces(MediaType.TEXT_PLAIN)
public class MessageResource {

    private static Logger logger = LogManager.getLogger(MessageResource.class);

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        String result = "Hello " + msg + "!";
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path( "/soh/transform" )
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN )
    public Response transformSOH(@Context HttpHeaders headers, String payload){
        logger.info("calling to transformSOH.....");

        logger.info("***payload=" + payload);
        logger.info("***headers: ");
        logger.info("api_key=" + headers.getHeaderString("api_key"));
        logger.info("tenant=" + headers.getHeaderString("tenant"));

        return Response.ok( "OK" ).build();
    }
}
