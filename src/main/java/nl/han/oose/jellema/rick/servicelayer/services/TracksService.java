package nl.han.oose.jellema.rick.servicelayer.services;

import nl.han.oose.jellema.rick.servicelayer.dto.TracksDTO;
import nl.han.oose.jellema.rick.resourcelayer.ICache;
import nl.han.oose.jellema.rick.resourcelayer.ITracksService;

import javax.inject.Inject;

public class TracksService implements ITracksService {

    private ITracksDao dao;
    private ICache cache;

    @Override
    public TracksDTO getTracksNotInPlaylist(String token, int playlistID) {
        this.cache.userExists(token);
        return this.dao.findTracksNotInPlaylist(playlistID);
    }

    @Inject
    public void setDao(ITracksDao dao){
        this.dao = dao;
    }
    @Inject
    public void setCache(ICache cache){
        this.cache = cache;
    }
}
