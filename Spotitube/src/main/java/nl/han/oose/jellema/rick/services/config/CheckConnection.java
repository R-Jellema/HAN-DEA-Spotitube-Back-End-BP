package nl.han.oose.jellema.rick.services.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check-connection")
public class CheckConnection {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String checkConnection(){
        return "Up & Running!";
    }
}
