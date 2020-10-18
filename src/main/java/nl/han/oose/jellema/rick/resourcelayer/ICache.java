package nl.han.oose.jellema.rick.resourcelayer;

import nl.han.oose.jellema.rick.servicelayer.dto.UserDTO;

public interface ICache {
     void addToCache(String token, UserDTO user);
     UserDTO getUser(String token);
     boolean userExists(String token);





}
