package nl.han.oose.jellema.rick.resources;


import nl.han.oose.jellema.rick.services.interfaces.IPlaylistService;
import nl.han.oose.jellema.rick.services.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.services.dto.PlaylistsDTO;
import nl.han.oose.jellema.rick.services.dto.TrackDTO;
import nl.han.oose.jellema.rick.services.dto.TracksDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

public class PlaylistResourceTest {

    final int PLAYLIST_ID = 1;
    final int TRACK_ID = 1;
    final String TOKEN = "TestToken";
    final private int HTTP_OK = 200;
    final private int HTTP_CREATED = 201;

    private PlaylistResource sut;
    private IPlaylistService mockedPlaylistService;
    private PlaylistsDTO playListsDTO;
    private PlaylistDTO playlist1, playlist2;
    private TracksDTO tracks;


    @BeforeEach
    public void setup() {
        this.sut = new PlaylistResource();
        this.mockedPlaylistService = mock(IPlaylistService.class);

        this.sut.setPlayListService(mockedPlaylistService);

        this.playlist1 = new PlaylistDTO(PLAYLIST_ID, "PlaylistA", true, new ArrayList<TrackDTO>(), "Rick");
        this.playlist2 = new PlaylistDTO(PLAYLIST_ID+1, "PlaylistB", true, new ArrayList<TrackDTO>(), "Rick");
        ArrayList<PlaylistDTO> playlists = new ArrayList<>();
        playlists.add(playlist1);
        playlists.add(playlist2);
        this.playListsDTO = new PlaylistsDTO(playlists);

        this.tracks = new TracksDTO();


        Mockito.when(this.mockedPlaylistService.getPlaylists("Token")).thenReturn(this.playListsDTO);
        Mockito.when(this.mockedPlaylistService.getTracksOfPlaylist("Token", PLAYLIST_ID)).thenReturn(this.tracks);
    }


    @Test
    public void getPlaylistsTestReturn200OK() {
        // Arrange

        // Act
        var response = this.sut.getPlaylists(any());
        // Assert
        assertEquals(response.getStatus(), this.HTTP_OK);
    }

    @Test
    public void getTracksofPlaylistShouldReturn200OK() {
        // Arrange

        // Act
        var response = this.sut.getTracksOfPlaylist(TOKEN, PLAYLIST_ID);
        // Assert
        assertEquals(response.getStatus(), this.HTTP_OK);
    }

    @Test
    public void editPlaylistShouldReturn200OK() {
        // Arrange

        // Act
        var response = this.sut.EditPlaylist(TOKEN, this.playlist1);
        // Assert
        assertEquals(response.getStatus(), this.HTTP_OK);
    }

    @Test
    public void createPlaylistShouldReturn201CREATED() {
        // Arrange

        // Act
        var response = this.sut.createPlaylist(TOKEN, this.playlist1);
        // Assert
        assertEquals(response.getStatus(), this.HTTP_CREATED);
    }

    @Test
    public void deletePlaylistShouldReturn200OK() {
        // Arrange

        // Act
        var response = this.sut.deletePlaylist(TOKEN, PLAYLIST_ID);
        // Assert
        assertEquals(response.getStatus(), this.HTTP_OK);
    }

    @Test
    public void deleteTrackFromPlaylistShouldReturn200OK(){
        // Arrange

        // Act
        var response = this.sut.deleteTrackFromPlaylist(TOKEN, PLAYLIST_ID, TRACK_ID);
        // Assert
        assertEquals(response.getStatus(), this.HTTP_OK);
    }

    @Test
    public void addTrackToPlaylistShouldReturn200OK(){
        // Arrange

        // Act
        var response = this.sut.addTrackToPlaylist(TOKEN, PLAYLIST_ID, new TrackDTO());
        // Assert
        assertEquals(response.getStatus(), this.HTTP_OK);
    }
}
