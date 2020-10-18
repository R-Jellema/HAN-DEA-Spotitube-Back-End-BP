package nl.han.oose.jellema.rick.servicelayer.dto;

import java.util.ArrayList;

public class TracksDTO {

    private ArrayList<TrackDTO> tracks = new ArrayList<TrackDTO>();

    public TracksDTO() {}

    public TracksDTO(ArrayList<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    public ArrayList<TrackDTO> getTracks() {
        return tracks;
    }

    public void addTrack(TrackDTO track){
        this.tracks.add(track);
    }
    public void setTracks(ArrayList<TrackDTO> tracks) {
        this.tracks = tracks;
    }
}
