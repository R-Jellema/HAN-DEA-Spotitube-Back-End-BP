package nl.han.oose.jellema.rick.services.interfaces;

import nl.han.oose.jellema.rick.services.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.services.dto.PlaylistsDTO;
import nl.han.oose.jellema.rick.services.dto.TrackDTO;
import nl.han.oose.jellema.rick.services.dto.TracksDTO;

public interface IPlaylistService {

    PlaylistsDTO getPlaylists(String token);

    TracksDTO getTracksOfPlaylist(String token, int playlistID);

    PlaylistsDTO editPlaylist(String token, PlaylistDTO playlist);

    PlaylistsDTO createPlaylist(String token, PlaylistDTO playlist);

    PlaylistsDTO deletePlaylist(String token, int id);

    TracksDTO deleteTrack(String token, int playlistID, int trackID);

    TracksDTO addTrack(String token, int playlistID, TrackDTO dto);
}
