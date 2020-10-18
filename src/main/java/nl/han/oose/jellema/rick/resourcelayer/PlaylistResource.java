package nl.han.oose.jellema.rick.resourcelayer;

import nl.han.oose.jellema.rick.servicelayer.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.TrackDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/playlists")
public class PlaylistResource {
    
    private IPlaylistService playListService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylists(@QueryParam("token") String token){
        return Response.ok().entity(this.playListService.getPlaylists(token)).build();
    }

    @GET()
    @Path("/{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracksOfPlaylist(@QueryParam("token") String token, @PathParam("id") int playlistID){
        return Response.ok().entity(this.playListService.getTracksOfPlaylist(token, playlistID)).build();
    }

    @PUT()
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response EditPlaylist(@QueryParam("token") String token, PlaylistDTO playlist){
        return Response.status(Response.Status.OK).entity(this.playListService.editPlaylist(token, playlist)).build();
    }
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlaylist(@QueryParam("token") String token, PlaylistDTO playlist){
        return Response.status(Response.Status.CREATED).entity(this.playListService.createPlaylist(token, playlist)).build();
    }

    @DELETE()
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePlaylist(@QueryParam("token") String token, @PathParam("id") int id){
        return Response.ok().entity(this.playListService.deletePlaylist(token, id)).build();
    }

    @DELETE
    @Path("/{id}/tracks/{trackid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTrackFromPlaylist(@QueryParam("token") String token, @PathParam("id") int playlistID, @PathParam("trackid") int trackID){
        return Response.ok().entity(this.playListService.deleteTrack(token, playlistID, trackID)).build();
    }

    @POST
    @Path("/{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrackToPlaylist(@QueryParam("token") String token, @PathParam("id") int playlistID, TrackDTO dto){
        return Response.ok().entity(this.playListService.addTrack(token, playlistID, dto)).build();
    }

    @Inject
    public void setPlayListService(IPlaylistService playListService){
        this.playListService = playListService;
    }

}
