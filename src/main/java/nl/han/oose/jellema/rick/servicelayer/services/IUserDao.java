package nl.han.oose.jellema.rick.servicelayer.services;

import nl.han.oose.jellema.rick.servicelayer.dto.UserDTO;

public interface IUserDao {
    UserDTO find(String username, String user);
}
