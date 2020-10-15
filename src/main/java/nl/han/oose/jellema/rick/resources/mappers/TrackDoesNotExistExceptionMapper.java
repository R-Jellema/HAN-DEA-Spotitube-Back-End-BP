package nl.han.oose.jellema.rick.resources.mappers;

import nl.han.oose.jellema.rick.services.exceptions.TrackDoesNotExistException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TrackDoesNotExistExceptionMapper implements ExceptionMapper<TrackDoesNotExistException> {
    @Override
    public Response toResponse(TrackDoesNotExistException e) {
        return Response.status(Response.Status.NOT_FOUND).entity("Track niet gevonden.").build();
    }
}
