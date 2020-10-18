package nl.han.oose.jellema.rick.resourcelayer;

import nl.han.oose.jellema.rick.servicelayer.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.PlaylistsDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.TrackDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.TracksDTO;

public interface IPlaylistService {

    PlaylistsDTO getPlaylists(String token);

    TracksDTO getTracksOfPlaylist(String token, int playlistID);

    PlaylistsDTO editPlaylist(String token, PlaylistDTO playlist);

    PlaylistsDTO createPlaylist(String token, PlaylistDTO playlist);

    PlaylistsDTO deletePlaylist(String token, int id);

    TracksDTO deleteTrack(String token, int playlistID, int trackID);

    TracksDTO addTrack(String token, int playlistID, TrackDTO dto);
}
