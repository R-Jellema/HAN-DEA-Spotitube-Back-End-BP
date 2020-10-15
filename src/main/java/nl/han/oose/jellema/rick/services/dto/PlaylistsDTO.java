package nl.han.oose.jellema.rick.services.dto;

import java.util.ArrayList;

public class PlaylistsDTO {
    private ArrayList<PlaylistDTO> playlists = new ArrayList<PlaylistDTO>();
    private int length;
    public PlaylistsDTO(){}

    public PlaylistsDTO(ArrayList<PlaylistDTO> playlists){
        this.playlists = playlists;
    }

    public void addToPlaylist(PlaylistDTO playlist){
        this.playlists.add(playlist);
    }

    public ArrayList<PlaylistDTO> getPlaylists(){
        return this.playlists;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }

    public void addToLength(int length){
        this.length += length;
    }
}
