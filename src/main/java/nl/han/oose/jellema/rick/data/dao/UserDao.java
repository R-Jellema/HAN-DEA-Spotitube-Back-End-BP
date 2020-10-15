package nl.han.oose.jellema.rick.data.dao;

import nl.han.oose.jellema.rick.data.dao.interfaces.IUserDao;
import nl.han.oose.jellema.rick.data.database.Database;
import nl.han.oose.jellema.rick.services.dto.UserDTO;
import java.sql.*;

public class UserDao implements IUserDao {

    public static final String DATABASE_PROPERTIES = "database.properties";
    public static final String SELECT_FROM_USERS_WHERE_USERNAME_LIKE = "SELECT * FROM users WHERE username LIKE ?";
    private Connection connection;

    @Override
    public UserDTO find(String column, String value) {
        UserDTO dto = new UserDTO();
        boolean foundUser = false;
        this.connection = new Database().createConnection(DATABASE_PROPERTIES);
        PreparedStatement st;
        try {
            st = connection.prepareStatement(SELECT_FROM_USERS_WHERE_USERNAME_LIKE);
            st.setString(1, value);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                foundUser = true;
                dto.setUser(rs.getString("username"));
                dto.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (foundUser) return dto;
        else return null;
    }

}
