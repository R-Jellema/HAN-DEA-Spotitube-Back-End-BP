package nl.han.oose.jellema.rick.servicelayer.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TracksDTOTest {

    private ArrayList<TrackDTO> tracks = new ArrayList<>();
    private TracksDTO dto;

    @BeforeEach
    void setUp() {
        this.dto = new TracksDTO(this.tracks);
    }

    @Test
    void getTracks() {
        assertEquals(this.tracks, this.dto.getTracks());
    }

    @Test
    void addTrack() {
        TrackDTO track = new TrackDTO();
        this.dto.addTrack(track);
        this.tracks.add(track);
        assertEquals(this.tracks, this.dto.getTracks());
    }

    @Test
    void setTracks() {
        this.dto.setTracks(this.tracks);
        assertEquals(this.tracks, this.dto.getTracks());
    }
}