package nl.han.oose.jellema.rick.servicelayer.services;

import nl.han.oose.jellema.rick.servicelayer.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.servicelayer.dto.PlaylistsDTO;

public interface IPlaylistsDao {

    PlaylistsDTO all();

    void edit(PlaylistDTO dto);

    void create(PlaylistDTO dto);

    void delete (int id);
}
