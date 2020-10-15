package nl.han.oose.jellema.rick.services.interfaces;

import nl.han.oose.jellema.rick.services.dto.UserDTO;

public interface ICache {
     void addToCache(String token, UserDTO user);
     UserDTO getUser(String token);
     boolean userExists(String token);





}
