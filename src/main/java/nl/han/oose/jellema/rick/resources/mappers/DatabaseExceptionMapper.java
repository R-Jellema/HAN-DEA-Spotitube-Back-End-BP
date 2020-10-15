package nl.han.oose.jellema.rick.resources.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.sql.SQLException;

@Provider
public class DatabaseExceptionMapper implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException throwables) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Er ging iets fout in de Database").build();
    }
}
