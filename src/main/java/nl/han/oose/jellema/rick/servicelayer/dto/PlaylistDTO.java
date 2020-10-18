package nl.han.oose.jellema.rick.servicelayer.dto;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;

public class PlaylistDTO {

    private int id;
    private String name;
    private boolean owner;
    private String user;
    private ArrayList<TrackDTO> tracks = new ArrayList<TrackDTO>();

    public PlaylistDTO(){}

    public PlaylistDTO(int id, String name, boolean owner, ArrayList<TrackDTO> tracks, String user){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.tracks = tracks;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public ArrayList<TrackDTO> getTracks() {
        return tracks;
    }

    public void addToTrack(TrackDTO track){
        this.tracks.add(track);
    }

    public void setTracks(ArrayList<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    @JsonIgnore
    public String getUser() {
        return user;
    }
    @JsonIgnore
    public void setUser(String user) {
        this.user = user;
    }



}
