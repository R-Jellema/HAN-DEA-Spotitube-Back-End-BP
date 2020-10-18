package nl.han.oose.jellema.rick.resourcelayer;



import nl.han.oose.jellema.rick.servicelayer.dto.UserDTO;


import javax.inject.Inject;
import nl.han.oose.jellema.rick.servicelayer.exceptions.AuthenticationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/login")
public class LoginResource {

    private ILoginService loginService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserDTO login) throws AuthenticationException {
        return Response.ok().entity(this.loginService.checkAuthentication(login)).build();
    }

    @Inject
    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }




}
