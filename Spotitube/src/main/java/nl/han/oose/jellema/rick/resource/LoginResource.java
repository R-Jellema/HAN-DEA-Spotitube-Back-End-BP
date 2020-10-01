package nl.han.oose.jellema.rick.resource;



import nl.han.oose.jellema.rick.services.dto.LoginDTO;
import nl.han.oose.jellema.rick.services.dto.UserDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO loginDTO){
        UserDTO userDTO = new UserDTO(loginDTO.getUser(), "123-132-123");
        System.out.println("REsponse active");
        return Response.ok().entity(userDTO).build();
    }

}
