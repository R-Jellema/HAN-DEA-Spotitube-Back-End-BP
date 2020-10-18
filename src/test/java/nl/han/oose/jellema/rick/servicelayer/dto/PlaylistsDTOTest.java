package nl.han.oose.jellema.rick.servicelayer.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistsDTOTest {

    private PlaylistsDTO sut;
    PlaylistDTO playlist;

    @BeforeEach
    void setup(){
        this.playlist = new PlaylistDTO();
        this.sut = new PlaylistsDTO();
    }

    @Test
    void addToPlaylist() {
        ArrayList<PlaylistDTO> playlist = new ArrayList<PlaylistDTO>();
        playlist.add(this.playlist);
        this.sut.addToPlaylist(this.playlist);
        assertEquals(playlist, this.sut.getPlaylists());
    }

    @Test
    void getPlaylists() {
        ArrayList<PlaylistDTO> playlist = new ArrayList<PlaylistDTO>();
        playlist.add(this.playlist);
        this.sut.addToPlaylist(this.playlist);
        assertEquals(playlist, this.sut.getPlaylists());
    }

    @Test
    void setLength() {
        this.sut.setLength(1);
        assertEquals(1, this.sut.getLength());
    }

    @Test
    void getLength() {
        this.sut.setLength(1);
        assertEquals(1, this.sut.getLength());
    }

    @Test
    void addToLength() {
        this.sut.addToLength(1);
        assertEquals(1, this.sut.getLength());
    }
}