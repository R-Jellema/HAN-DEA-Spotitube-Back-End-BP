package nl.han.oose.jellema.rick.data.dao.interfaces;

import nl.han.oose.jellema.rick.services.dto.TrackDTO;
import nl.han.oose.jellema.rick.services.dto.TracksDTO;

public interface ITracksDao {
    TracksDTO findTracksByPlaylistID(int id);

    TrackDTO findTrackByID(int id);

    TracksDTO delete(int playlistID, int trackID);

    TracksDTO add(int playlistID, int trackID);

    TracksDTO findTracksNotInPlaylist(int playlistID);

}
