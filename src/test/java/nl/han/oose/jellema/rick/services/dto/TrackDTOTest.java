package nl.han.oose.jellema.rick.services.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TrackDTOTest {

    private TrackDTO dto;
    private TrackDTO empty;
    private Date date;

    @BeforeEach
    void setUp() {
        this.date = new Date();
        this.dto = new TrackDTO(1, "title", "performer", 200, "album", 200, this.date, "description", true);
        this.empty = new TrackDTO();
    }


    @Test
    void getId() {
        assertEquals(1, this.dto.getId());
    }

    @Test
    void setId() {
        this.empty.setId(1);
        assertEquals(1, this.empty.getId());
    }

    @Test
    void getPlaycount() {
        assertEquals(200, this.dto.getPlaycount());
    }

    @Test
    void setPlaycount() {
        this.empty.setPlaycount(1);
        assertEquals(1, this.empty.getPlaycount());
    }

    @Test
    void getDuration() {
        assertEquals(200, this.dto.getDuration());
    }

    @Test
    void setDuration() {
        this.empty.setDuration(1);
        assertEquals(1, this.empty.getDuration());
    }

    @Test
    void getTitle() {
        assertEquals("title", this.dto.getTitle());
    }

    @Test
    void setTitle() {
        this.empty.setTitle("title");
        assertEquals("title", this.empty.getTitle());
    }

    @Test
    void getPerformer() {
        assertEquals("performer", this.dto.getPerformer());

    }

    @Test
    void setPerformer() {
        this.empty.setPerformer("performer");
        assertEquals("performer", this.empty.getPerformer());
    }

    @Test
    void getAlbum() {
        assertEquals("album", this.dto.getAlbum());
    }

    @Test
    void setAlbum() {
        this.empty.setAlbum("album");
        assertEquals("album", this.empty.getAlbum());
    }

    @Test
    void getDescription() {
        assertEquals("description", this.dto.getDescription());
    }

    @Test
    void setDescription() {
        this.empty.setDescription("description");
        assertEquals("description", this.empty.getDescription());
    }

    @Test
    void isOfflineAvailable() {
        assertTrue(this.dto.isOfflineAvailable());
    }

    @Test
    void setOfflineAvailable() {
        this.empty.setOfflineAvailable(true);
        assertTrue(this.empty.isOfflineAvailable());
    }

    @Test
    void getPublicationDate() {
        assertEquals(this.date, this.dto.getPublicationDate());
    }

    @Test
    void setPublicationDate() {
        Date date = new Date();
        this.empty.setPublicationDate(date);
        assertEquals(date, this.empty.getPublicationDate());
    }

}