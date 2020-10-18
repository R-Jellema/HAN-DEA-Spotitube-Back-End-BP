package nl.han.oose.jellema.rick.resourcelayer.mappers;

import nl.han.oose.jellema.rick.servicelayer.exceptions.TrackDoesNotExistException;

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
