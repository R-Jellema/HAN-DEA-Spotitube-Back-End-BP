package nl.han.oose.jellema.rick.data.dao.interfaces;

import nl.han.oose.jellema.rick.services.dto.UserDTO;

public interface IUserDao {
    UserDTO find(String username, String user);
}
