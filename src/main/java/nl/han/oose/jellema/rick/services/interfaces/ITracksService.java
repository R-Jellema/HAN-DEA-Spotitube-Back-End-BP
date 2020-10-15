package nl.han.oose.jellema.rick.services.interfaces;

import nl.han.oose.jellema.rick.services.dto.TracksDTO;

public interface ITracksService {
    TracksDTO getTracksNotInPlaylist(String token, int playlistID);
}
