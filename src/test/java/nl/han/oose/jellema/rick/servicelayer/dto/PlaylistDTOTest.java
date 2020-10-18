package nl.han.oose.jellema.rick.servicelayer.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PlaylistDTOTest {

    private PlaylistDTO dto;
    private PlaylistDTO emptyDto;
    private final int ID = 1;
    private final String NAME = "name";
    private final boolean OWNER = true;
    private final String USER = "Rick";
    private final ArrayList<TrackDTO> TRACKS = new ArrayList<TrackDTO>();

    @BeforeEach
    void setUp() {
        this.dto = new PlaylistDTO(ID, NAME, OWNER, TRACKS, USER);
        this.emptyDto = new PlaylistDTO();
    }

    @Test
    void getIdShouldGetid() {
        var response = this.dto.getId();
        Assertions.assertEquals(ID, response);
    }

    @Test
    void setIdShouldSetid() {
        this.emptyDto.setId(ID);
        Assertions.assertEquals(ID, this.emptyDto.getId());
    }

    @Test
    void getNameShouldGetName() {
        Assertions.assertEquals(NAME, this.dto.getName());
    }

    @Test
    void setNameShouldSetName() {
        this.emptyDto.setName(NAME);
        Assertions.assertEquals(NAME, this.emptyDto.getName());
    }

    @Test
    void isOwnerShouldGetOwner() {
        Assertions.assertTrue(this.dto.isOwner());
    }

    @Test
    void setOwnerShouldSetOwner() {
        this.emptyDto.setOwner(OWNER);
        Assertions.assertEquals(OWNER, this.emptyDto.isOwner());
    }

    @Test
    void getTracksShouldGetTracks() {
        Assertions.assertEquals(TRACKS,this.dto.getTracks());
    }

    @Test
    void addToTrackShouldAddToTracks() {
        TrackDTO tDto = new TrackDTO();
        ArrayList<TrackDTO> track = new ArrayList<>();
        track.add(tDto);
        this.emptyDto.addToTrack(tDto);
        Assertions.assertEquals(track, this.emptyDto.getTracks());
    }

    @Test
    void setTracksShouldSetTracks() {
        this.emptyDto.setTracks(TRACKS);
        Assertions.assertEquals(TRACKS, this.emptyDto.getTracks());
    }
}