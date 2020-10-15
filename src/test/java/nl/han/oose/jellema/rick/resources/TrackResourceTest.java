package nl.han.oose.jellema.rick.resources;


import nl.han.oose.jellema.rick.services.dto.TracksDTO;
import nl.han.oose.jellema.rick.services.interfaces.ITracksService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TrackResourceTest {

    final String TOKEN = "TestToken";
    final int PLAYLIST_ID = 1;
    final TracksDTO EXPECTED_DTO = new TracksDTO();
    final int HTTP_OK = 200;
    private ITracksService mockedTrackService;
    private TrackResource sut;


    @BeforeEach
    void setup(){
        this.sut = new TrackResource();
        this.mockedTrackService = Mockito.mock(ITracksService.class);
        this.sut.setTracksService(this.mockedTrackService);
        Mockito.when(this.mockedTrackService.getTracksNotInPlaylist(TOKEN, PLAYLIST_ID)).thenReturn(EXPECTED_DTO);
    }

    @Test
    void getTracksShouldReturn200OK() {
        var response = this.sut.getTracks(TOKEN, PLAYLIST_ID);

        assertEquals(response.getStatus(), HTTP_OK);
    }


}