package nl.han.oose.jellema.rick.resourcelayer;

import nl.han.oose.jellema.rick.servicelayer.exceptions.AuthenticationException;
import nl.han.oose.jellema.rick.servicelayer.dto.UserDTO;

public interface ILoginService {
    UserDTO checkAuthentication(UserDTO userDTO) throws AuthenticationException;
}
