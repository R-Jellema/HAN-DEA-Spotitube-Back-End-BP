package nl.han.oose.jellema.rick.services;

import nl.han.oose.jellema.rick.services.exceptions.InvalidTokenException;
import nl.han.oose.jellema.rick.services.dto.UserDTO;
import nl.han.oose.jellema.rick.services.interfaces.ICache;

import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class Cache implements ICache {
    private HashMap<String, UserDTO> cache = new HashMap<>();

    @Override
    public void addToCache(String token, UserDTO user){
        this.cache.put(token, user);
    }

    @Override
    public UserDTO getUser(String token){
        this.userExists(token);
        return this.cache.get(token);
    }

    @Override
    public boolean userExists(String token){
        if(!this.cache.containsKey(token)) throw new InvalidTokenException();
        else return true;
    }



}
