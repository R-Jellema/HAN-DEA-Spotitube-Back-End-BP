package nl.han.oose.jellema.rick.resourcelayer.mappers;

import nl.han.oose.jellema.rick.servicelayer.exceptions.FileNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FileNotFoundExceptionMapper implements ExceptionMapper<FileNotFoundException> {
    @Override
    public Response toResponse(FileNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity("Propertiesfile niet gevonden.").build();
    }
}
