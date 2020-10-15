package nl.han.oose.jellema.rick.services.interfaces;

import nl.han.oose.jellema.rick.services.exceptions.AuthenticationException;
import nl.han.oose.jellema.rick.services.dto.UserDTO;

public interface ILoginService {
    UserDTO checkAuthentication(UserDTO userDTO) throws AuthenticationException;
}
