package nl.han.oose.jellema.rick.servicelayer.services;

import nl.han.oose.jellema.rick.servicelayer.dto.TrackDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.TracksDTO;

public interface ITracksDao {
    TracksDTO findTracksByPlaylistID(int id);

    TrackDTO findTrackByID(int id);

    TracksDTO delete(int playlistID, int trackID);

    TracksDTO add(int playlistID, int trackID);

    TracksDTO findTracksNotInPlaylist(int playlistID);

}
