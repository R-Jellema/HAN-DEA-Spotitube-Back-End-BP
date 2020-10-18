package nl.han.oose.jellema.rick.resourcelayer;

import nl.han.oose.jellema.rick.servicelayer.dto.TracksDTO;

public interface ITracksService {
    TracksDTO getTracksNotInPlaylist(String token, int playlistID);
}
