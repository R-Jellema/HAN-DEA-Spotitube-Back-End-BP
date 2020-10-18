package nl.han.oose.jellema.rick.servicelayer;

import nl.han.oose.jellema.rick.servicelayer.services.IPlaylistsDao;
import nl.han.oose.jellema.rick.servicelayer.services.ITracksDao;
import nl.han.oose.jellema.rick.datalayer.dao.PlaylistsDao;
import nl.han.oose.jellema.rick.datalayer.dao.TracksDao;
import nl.han.oose.jellema.rick.servicelayer.dto.*;
import nl.han.oose.jellema.rick.resourcelayer.ICache;
import nl.han.oose.jellema.rick.servicelayer.services.Cache;
import nl.han.oose.jellema.rick.servicelayer.services.PlaylistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;

public class PlaylistServiceTest {

    private PlaylistService sut;
    private ICache mockCache;
    private IPlaylistsDao mockPlaylistsDao;
    private ITracksDao mockTracksDao;
    private final String TOKEN = "TestToken";
    private PlaylistsDTO expectedDTO;
    private TracksDTO expectedTracksDTO;


    @BeforeEach
    public void setup() {
        this.sut = new PlaylistService();
        this.mockCache = Mockito.mock(Cache.class);
        this.mockPlaylistsDao = Mockito.mock(PlaylistsDao.class);
        this.mockTracksDao = Mockito.mock(TracksDao.class);

        this.sut.setCacheService(mockCache);
        this.sut.setTracksDao(mockTracksDao);
        this.sut.setPlaylistsDao(mockPlaylistsDao);

        expectedDTO = new PlaylistsDTO();
        PlaylistDTO playlistDTO1 = new PlaylistDTO(1, "Name", true, new ArrayList<TrackDTO>(), "Rick");
        PlaylistDTO playlistDTO2 = new PlaylistDTO(2, "Name", true, new ArrayList<TrackDTO>(), "Rick");
        expectedDTO.addToPlaylist(playlistDTO1);
        expectedDTO.addToPlaylist(playlistDTO2);

        expectedTracksDTO = new TracksDTO();
        TrackDTO trackDTO1 = new TrackDTO(1, "Titel", "Performer", 100, "Album", 100, new Date(), "Beschrijving", false);
        TrackDTO trackDTO2 = new TrackDTO(2, "Titel", "Performer", 100, "Album", 100, new Date(), "Beschrijving", false);
        expectedTracksDTO.addTrack(trackDTO1);
        expectedTracksDTO.addTrack(trackDTO2);

        Mockito.when(mockCache.userExists(TOKEN)).thenReturn(true);
        Mockito.when(mockPlaylistsDao.all()).thenReturn(expectedDTO);

        Mockito.when(mockTracksDao.delete(10, 2)).thenReturn(expectedTracksDTO);
        Mockito.when(mockTracksDao.add(10, expectedTracksDTO.getTracks().get(0).getId())).thenReturn(expectedTracksDTO);
        Mockito.when(mockTracksDao.findTracksByPlaylistID(1)).thenReturn(expectedTracksDTO);
        Mockito.when(mockTracksDao.findTrackByID(1)).thenReturn(expectedTracksDTO.getTracks().get(0));

        Mockito.when(mockCache.getUser(TOKEN)).thenReturn(new UserDTO("Rick", TOKEN, "12345"));


    }

    @Test
    public void getPlaylistsShouldReturnPlaylistsTest() {
        // Act
        var response = this.sut.getPlaylists(TOKEN);
        // Assert
        Assertions.assertEquals(expectedDTO, response);
        Mockito.verify(mockCache).userExists(TOKEN);
    }

    @Test
    public void getTracksOfPlaylistShouldReturnTracksOfAPlaylistTest() {
        // Act
        var response = this.sut.getTracksOfPlaylist(TOKEN, 1);
        // Assert
        Assertions.assertEquals(expectedTracksDTO, response);
        Mockito.verify(mockCache).userExists(TOKEN);
    }

    @Test
    public void getTracksOfPlaylistShouldReturnNull() {
        // Arrange
        TracksDTO emptyTracks = new TracksDTO();
        Mockito.when(mockTracksDao.findTracksByPlaylistID(6)).thenReturn(emptyTracks);

        // Act
        var response = this.sut.getTracksOfPlaylist(TOKEN, 6);
        // Assert
        Assertions.assertEquals(emptyTracks, response);
        Mockito.verify(mockCache).userExists(TOKEN);
        Mockito.verify(mockTracksDao).findTracksByPlaylistID(6);
    }

    @Test
    public void editPlaylistShouldReturnPlaylists() {
        // Arrange
        PlaylistDTO playlistDTO1 = new PlaylistDTO(1, "Name", true, new ArrayList<TrackDTO>(), "Rick");

        // Act
        var response = this.sut.editPlaylist(TOKEN, playlistDTO1);

        // Assert
        Assertions.assertEquals(expectedDTO, response);
        Mockito.verify(mockPlaylistsDao).edit(playlistDTO1);
    }

    @Test
    public void createPlaylistShouldReturnPlaylists() {
        // Arrange
        PlaylistDTO playlistDTO1 = new PlaylistDTO(1, "Name", true, new ArrayList<TrackDTO>(), "Rick");

        // Act
        var response = this.sut.createPlaylist(TOKEN, playlistDTO1);

        // Assert
        Assertions.assertEquals(expectedDTO, response);
        Mockito.verify(mockPlaylistsDao).create(playlistDTO1);
    }

    @Test
    public void deletePlaylistShouldReturnPlaylists() {
        // Arrange

        // Act
        var response = this.sut.deletePlaylist(TOKEN, 10);

        // Assert
        Assertions.assertEquals(expectedDTO, response);
        Mockito.verify(mockPlaylistsDao).delete(10);
    }

    @Test
    public void deleteTrackShouldReturnTracksDTO() {
        // Arrange

        // Act
        var response = this.sut.deleteTrack(TOKEN, 10, 2);

        // Assert
        Assertions.assertEquals(expectedTracksDTO, response);
        Mockito.verify(mockTracksDao).delete(10, 2);
    }

    @Test
    void addTrackShouldReturnTracksDTO() {
        // Arrange

        // Act
        var response = this.sut.addTrack(TOKEN, 10, expectedTracksDTO.getTracks().get(0));
        // Assert
        Assertions.assertEquals(expectedTracksDTO, response);
        Mockito.verify(mockTracksDao).add(10, expectedTracksDTO.getTracks().get(0).getId());
    }
}
