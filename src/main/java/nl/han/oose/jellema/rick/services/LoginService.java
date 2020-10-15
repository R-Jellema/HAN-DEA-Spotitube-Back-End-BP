package nl.han.oose.jellema.rick.services;

import nl.han.oose.jellema.rick.data.dao.interfaces.IUserDao;
import nl.han.oose.jellema.rick.data.dao.UserDao;
import nl.han.oose.jellema.rick.services.exceptions.AuthenticationException;
import nl.han.oose.jellema.rick.services.dto.UserDTO;
import nl.han.oose.jellema.rick.services.interfaces.ICache;
import nl.han.oose.jellema.rick.services.interfaces.ILoginService;
import nl.han.oose.jellema.rick.services.interfaces.ITokenDealer;


import javax.inject.Inject;

public class LoginService implements ILoginService {

    private ICache cache;
    private ITokenDealer dealer;

    @Override
    public UserDTO checkAuthentication(UserDTO userDTO) throws AuthenticationException {
        IUserDao userDao = new UserDao();
        UserDTO foundUser = userDao.find("username", userDTO.getUser());
        if (foundUser == null) throw new AuthenticationException();
        if (!this.authenticateUserPasswords(userDTO.getPassword(), foundUser.getPassword())) throw new AuthenticationException();
        userDTO.setToken(this.dealer.aquireToken());
        this.cache.addToCache(userDTO.getToken(), userDTO);
        return userDTO;
    }


    private boolean authenticateUserPasswords(String passwordInput, String passwordDatabase) {
        return passwordDatabase.equals(passwordInput);
    }

    @Inject
    public void setCacheService(ICache cache) {
        this.cache = cache;
    }

    @Inject
    public void setTokenDealerService(ITokenDealer dealer) {
        this.dealer = dealer;
    }
}
