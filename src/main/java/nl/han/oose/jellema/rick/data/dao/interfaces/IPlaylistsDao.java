package nl.han.oose.jellema.rick.data.dao.interfaces;

import nl.han.oose.jellema.rick.services.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.services.dto.PlaylistsDTO;

public interface IPlaylistsDao {

    PlaylistsDTO all();

    void edit(PlaylistDTO dto);

    void create(PlaylistDTO dto);

    void delete (int id);
}
