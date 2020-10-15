package nl.han.oose.jellema.rick.data.dao;

import nl.han.oose.jellema.rick.data.dao.interfaces.IPlaylistsDao;
import nl.han.oose.jellema.rick.data.database.Database;
import nl.han.oose.jellema.rick.services.dto.PlaylistDTO;
import nl.han.oose.jellema.rick.services.dto.PlaylistsDTO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistsDao implements IPlaylistsDao {

    public static final String SELECT_ALL_TRACKS_OF_PLAYLIST =
            "SELECT * FROM tracks " +
            "JOIN tracks_of_playlist t on tracks.id = t.trackID WHERE t.playlistID = ? ";
    public static final String SELECT_FROM_PLAYLISTS = "SELECT * FROM playlists";
    public static final String UPDATE_PLAYLISTS_SET_NAME_OWNER_WHERE_ID = "UPDATE playlists SET name = ?,  owner = ? WHERE id = ?";
    public static final String INSERT_INTO_PLAYLISTS_VALUES = "INSERT INTO playlists values(?, ?)";
    public static final String DELETE_FROM_TRACKS_OF_PLAYLIST_WHERE_PLAYLIST_ID = "DELETE FROM tracks_of_playlist where playlistID = ?";
    public static final String DELETE_FROM_PLAYLISTS_WHERE_ID = "DELETE FROM playlists WHERE id = ?";
    public static final String DATABASE_PROPERTIES = "database.properties";
    private Database database;
    private Connection connection;

    @Override
    public PlaylistsDTO all() {

        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        PlaylistsDTO playlists = new PlaylistsDTO();
        try {
            st = this.connection.prepareStatement(SELECT_FROM_PLAYLISTS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                PlaylistDTO playlist = new PlaylistDTO();
                playlist.setId(rs.getInt("id"));
                playlist.setName(rs.getString("name"));
                playlist.setUser(rs.getString("owner"));
                playlists.addToPlaylist(playlist);

                st = this.connection.prepareStatement(
                        SELECT_ALL_TRACKS_OF_PLAYLIST
                );

                st.setInt(1, playlist.getId());
                ResultSet tracks = st.executeQuery();

                while (tracks.next()) playlists.addToLength(tracks.getInt("duration"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return playlists;
    }

    @Override
    public void edit(PlaylistDTO dto) {
        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        try {
            st = this.connection.prepareStatement(UPDATE_PLAYLISTS_SET_NAME_OWNER_WHERE_ID);
            st.setString(1, dto.getName());
            st.setBoolean(2, dto.isOwner());
            st.setInt(3, dto.getId());

            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void create(PlaylistDTO dto) {
        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        try {
            st = this.connection.prepareStatement(INSERT_INTO_PLAYLISTS_VALUES);
            st.setString(1, dto.getName());
            st.setString(2, dto.getUser());

            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        try {
            st = this.connection.prepareStatement(DELETE_FROM_TRACKS_OF_PLAYLIST_WHERE_PLAYLIST_ID);
            st.setInt(1, id);
            st.executeUpdate();
            st = this.connection.prepareStatement(DELETE_FROM_PLAYLISTS_WHERE_ID);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Inject
    public void setDatabase(Database database) {
        this.database = database;
    }

}
