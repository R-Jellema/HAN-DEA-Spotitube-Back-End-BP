package nl.han.oose.jellema.rick.servicelayer;

import nl.han.oose.jellema.rick.servicelayer.services.ITracksDao;
import nl.han.oose.jellema.rick.datalayer.dao.TracksDao;
import nl.han.oose.jellema.rick.servicelayer.dto.TrackDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.TracksDTO;
import nl.han.oose.jellema.rick.resourcelayer.ICache;
import nl.han.oose.jellema.rick.servicelayer.services.Cache;
import nl.han.oose.jellema.rick.servicelayer.services.TracksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

class TracksServiceTest {

    private TracksService sut;
    private ITracksDao mockedTracksDao;
    private ICache mockCache;
    private final String TOKEN = "TestToken";
    private final int PLAYLIST_ID = 1;
    private final TracksDTO EXPECTED_DTO = new TracksDTO(new ArrayList<TrackDTO>());


    @BeforeEach
    void setup(){
        this.sut = new TracksService();
        this.mockedTracksDao = Mockito.mock(TracksDao.class);
        this.mockCache = Mockito.mock(Cache.class);
        this.sut.setCache(this.mockCache);
        this.sut.setDao(this.mockedTracksDao);
        Mockito.when(this.mockedTracksDao.findTracksNotInPlaylist(PLAYLIST_ID)).thenReturn(EXPECTED_DTO);
    }

    @Test
    void getTracksNotInPlaylistShouldReturnTracksDTO() {
        // Arrange

        // Act
        var response = this.sut.getTracksNotInPlaylist(TOKEN, PLAYLIST_ID);
        // Assert
        Assertions.assertEquals(EXPECTED_DTO, response);

    }
}