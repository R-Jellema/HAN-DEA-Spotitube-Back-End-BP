package nl.han.oose.jellema.rick.servicelayer.services;

import nl.han.oose.jellema.rick.servicelayer.exceptions.TrackDoesNotExistException;
import nl.han.oose.jellema.rick.servicelayer.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.PlaylistsDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.TrackDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.TracksDTO;
import nl.han.oose.jellema.rick.resourcelayer.ICache;
import nl.han.oose.jellema.rick.resourcelayer.IPlaylistService;

import javax.inject.Inject;


public class PlaylistService implements IPlaylistService {
    private ICache cache;
    private IPlaylistsDao playlistsDao;
    private ITracksDao tracksDao;


    @Override
    public PlaylistsDTO getPlaylists(String token){
        this.cache.userExists(token);
        PlaylistsDTO dtos = this.playlistsDao.all();
        dtos.getPlaylists().forEach((dto) -> dto.setOwner(this.cache.getUser(token).getUser().equals(dto.getUser())));
        return dtos;
    }

    @Override
    public TracksDTO getTracksOfPlaylist(String token, int playlistID) {
        this.cache.userExists(token);
        return this.tracksDao.findTracksByPlaylistID(playlistID);
    }

    @Override
    public PlaylistsDTO editPlaylist(String token, PlaylistDTO playlist) {
        this.cache.userExists(token);
        this.playlistsDao.edit(playlist);
        return this.getPlaylists(token);
    }

    @Override
    public PlaylistsDTO createPlaylist(String token, PlaylistDTO playlist) {
        if(this.cache.userExists(token)) playlist.setOwner(true);
        playlist.setUser(this.cache.getUser(token).getUser());
        this.playlistsDao.create(playlist);
        return this.getPlaylists(token);
    }

    @Override
    public PlaylistsDTO deletePlaylist(String token, int id) {
        this.cache.userExists(token);
        this.playlistsDao.delete(id);
        return this.getPlaylists(token);
    }

    @Override
    public TracksDTO deleteTrack(String token, int playlistID, int trackID) {
        this.cache.userExists(token);
        return this.tracksDao.delete(playlistID, trackID);
    }

    @Override
    public TracksDTO addTrack(String token, int playlistID, TrackDTO dto){
        this.cache.userExists(token);
        TrackDTO trackDTO = this.tracksDao.findTrackByID(dto.getId());
        if(trackDTO.getTitle() == null) throw new TrackDoesNotExistException();
        return this.tracksDao.add(playlistID, trackDTO.getId());
    }

    @Inject
    public void setCacheService(ICache cache){ this.cache = cache; }

    @Inject
    public void setPlaylistsDao(IPlaylistsDao playlistsDao){ this.playlistsDao = playlistsDao; }

    @Inject
    public void setTracksDao(ITracksDao tracksDao){ this.tracksDao = tracksDao; }
}
