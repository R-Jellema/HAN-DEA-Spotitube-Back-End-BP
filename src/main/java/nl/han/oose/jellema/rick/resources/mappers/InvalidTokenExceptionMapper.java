package nl.han.oose.jellema.rick.resources.mappers;

import nl.han.oose.jellema.rick.services.exceptions.InvalidTokenException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidTokenExceptionMapper implements ExceptionMapper<InvalidTokenException> {

    @Override
    public Response toResponse(InvalidTokenException e) {
        return Response.status(Response.Status.FORBIDDEN).entity("Geen juiste authenticatie token.").build();
    }
}
