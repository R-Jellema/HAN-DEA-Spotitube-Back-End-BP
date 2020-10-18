package nl.han.oose.jellema.rick.resourcelayer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/tracks")
public class TrackResource {

    private ITracksService tracksService;

    @GET
    public Response getTracks(@QueryParam("token") String token, @QueryParam("forPlaylist") int playlistID){
        return Response.ok().entity(this.tracksService.getTracksNotInPlaylist(token, playlistID)).build();
    }


    @Inject
    public void setTracksService(ITracksService service){
        this.tracksService = service;

    }

}
