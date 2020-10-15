package nl.han.oose.jellema.rick.resources.mappers;


import nl.han.oose.jellema.rick.services.exceptions.AuthenticationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationException> {
    @Override
    public Response toResponse(AuthenticationException e) {
        return Response.status(Response.Status.UNAUTHORIZED).entity("Foutief wachtwoord of gebruikersnaam").build();
    }
}
