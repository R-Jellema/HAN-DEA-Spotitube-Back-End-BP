package nl.han.oose.jellema.rick.data.dao;

import nl.han.oose.jellema.rick.data.dao.interfaces.ITracksDao;
import nl.han.oose.jellema.rick.data.database.Database;
import nl.han.oose.jellema.rick.services.dto.TrackDTO;
import nl.han.oose.jellema.rick.services.dto.TracksDTO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TracksDao implements ITracksDao {

    public static final String SELECT_TRACKS_BY_PLAYLIST_ID =
            "SELECT t.* FROM tracks t " +
            "INNER JOIN tracks_of_playlist tofp ON t.id = tofp.trackid " +
            "WHERE tofp.playlistID = ?";
    public static final String FIND_TRACK_ID = "SELECT t.* FROM tracks t WHERE t.id = ? ";
    public static final String DELETE_FROM_TRACKS_OF_PLAYLIST_WHERE_PLAYLISTID_AND_TRACKID = "DELETE FROM tracks_of_playlist WHERE playlistid = ? and trackid = ?";
    public static final String INSERT_INTO_TRACKS_OF_PLAYLIST_VALUES = "INSERT INTO tracks_of_playlist VALUES (?,?)";
    public static final String FIND_TRACKS_NOT_IN_PLAYLIST =
            "SELECT * FROM tracks t " +
            "WHERE t.id NOT IN (SELECT pt.trackID FROM tracks_of_playlist pt WHERE pt.playlistID = ?)";
    public static final String DATABASE_PROPERTIES = "database.properties";
    private Database database;
    private Connection connection;

    @Override
    public TracksDTO findTracksByPlaylistID(int id) {
        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        TracksDTO tracksDTO = new TracksDTO();
        try {
            st = this.connection.prepareStatement(
                    SELECT_TRACKS_BY_PLAYLIST_ID
            );
            st.setInt(1, id);
            ResultSet rsTracks = st.executeQuery();
            if(!rsTracks.next()) return new TracksDTO();
            else {
                do {
                    TrackDTO track = new TrackDTO();
                    track.setId(rsTracks.getInt("id"));
                    track.setPlaycount(rsTracks.getInt("playcount"));
                    track.setDuration(rsTracks.getInt("duration"));
                    track.setTitle(rsTracks.getString("title"));
                    track.setPerformer(rsTracks.getString("performer"));
                    track.setDescription(rsTracks.getString("description"));
                    track.setAlbum(rsTracks.getString("album"));
                    track.setOfflineAvailable(rsTracks.getBoolean("offlineAvailable"));
                    track.setPublicationDate(rsTracks.getDate("publicationDate"));
                    tracksDTO.addTrack(track);
                } while (rsTracks.next());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return tracksDTO;
    }

    @Override
    public TrackDTO findTrackByID(int id){
        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        TrackDTO track = new TrackDTO();
        try {
            st = this.connection.prepareStatement(
                    FIND_TRACK_ID
            );
            st.setInt(1, id);
            ResultSet rsTrack = st.executeQuery();
            if(!rsTrack.next()) return new TrackDTO();
            else {
                do {
                    track.setId(rsTrack.getInt("id"));
                    track.setPlaycount(rsTrack.getInt("playcount"));
                    track.setDuration(rsTrack.getInt("duration"));
                    track.setTitle(rsTrack.getString("title"));
                    track.setPerformer(rsTrack.getString("performer"));
                    track.setDescription(rsTrack.getString("description"));
                    track.setAlbum(rsTrack.getString("album"));
                    track.setOfflineAvailable(rsTrack.getBoolean("offlineAvailable"));
                    track.setPublicationDate(rsTrack.getDate("publicationDate"));
                } while (rsTrack.next());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return track;
    }

    @Override
    public TracksDTO delete(int playlistID, int trackID) {
        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        TracksDTO tracksDTO = new TracksDTO();
        try{
            st = this.connection.prepareStatement(
                    DELETE_FROM_TRACKS_OF_PLAYLIST_WHERE_PLAYLISTID_AND_TRACKID
            );

            st.setInt(1, playlistID);
            st.setInt(2, trackID);
            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return this.findTracksByPlaylistID(playlistID);
    }
    @Override
    public TracksDTO add(int playlistID, int trackID){

        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        TracksDTO tracksDTO = new TracksDTO();
        try {
            st = this.connection.prepareStatement(
                    INSERT_INTO_TRACKS_OF_PLAYLIST_VALUES
            );
            st.setInt(1, playlistID);
            st.setInt(2, trackID);
            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return this.findTracksByPlaylistID(playlistID);
    }

    @Override
    public TracksDTO findTracksNotInPlaylist(int playlistID){
        this.connection = this.database.createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        TracksDTO tracksDTO = new TracksDTO();
        try {
            st = this.connection.prepareStatement(
                    FIND_TRACKS_NOT_IN_PLAYLIST
            );
            st.setInt(1, playlistID);
            ResultSet rsTrack = st.executeQuery();
            if(!rsTrack.next()) return new TracksDTO();
            else {
                do {
                    TrackDTO track = new TrackDTO();
                    track.setId(rsTrack.getInt("id"));
                    track.setPlaycount(rsTrack.getInt("playcount"));
                    track.setDuration(rsTrack.getInt("duration"));
                    track.setTitle(rsTrack.getString("title"));
                    track.setPerformer(rsTrack.getString("performer"));
                    track.setDescription(rsTrack.getString("description"));
                    track.setAlbum(rsTrack.getString("album"));
                    track.setOfflineAvailable(rsTrack.getBoolean("offlineAvailable"));
                    track.setPublicationDate(rsTrack.getDate("publicationDate"));
                    tracksDTO.addTrack(track);
                } while (rsTrack.next());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return tracksDTO;
    }


    @Inject
    public void setDatabase(Database database) {
        this.database = database;
    }




}
