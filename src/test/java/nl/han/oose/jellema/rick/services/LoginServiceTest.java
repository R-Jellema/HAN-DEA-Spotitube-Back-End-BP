package nl.han.oose.jellema.rick.services;

import nl.han.oose.jellema.rick.data.dao.interfaces.IUserDao;
import nl.han.oose.jellema.rick.data.dao.UserDao;
import nl.han.oose.jellema.rick.services.exceptions.AuthenticationException;
import nl.han.oose.jellema.rick.services.dto.UserDTO;
import nl.han.oose.jellema.rick.services.interfaces.ICache;
import nl.han.oose.jellema.rick.services.interfaces.ITokenDealer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class LoginServiceTest {

    private LoginService sut;
    private ICache mockedCache;
    private UserDTO userDTO, loginDTO, loginDTOFail;
    private ITokenDealer mockedDealer;
    private IUserDao dao;
    private final String TOKEN = "TestToken";


    @BeforeEach
    public void setup() {
        // prepare
        loginDTO = new UserDTO("Rick", null, "12345");
        loginDTOFail = new UserDTO("Kees", null, "Kaas");
        userDTO = new UserDTO("Rick", TOKEN, "12345");


        this.sut = new LoginService();
        this.mockedCache = Mockito.mock(Cache.class);
        this.mockedDealer = Mockito.mock(TokenDealer.class);
        this.dao = Mockito.mock(UserDao.class);
        this.sut.setCacheService(this.mockedCache);
        this.sut.setTokenDealerService(this.mockedDealer);

        Mockito.doReturn(userDTO).when(dao).find("username", loginDTO.getUser());
        Mockito.doReturn(TOKEN).when(mockedDealer).aquireToken();

    }

    @Test
    public void checkAuthenticationSuccessTest() {
        // Act
        var response = this.sut.checkAuthentication(this.loginDTO);

        // Assert
        Assertions.assertEquals(response.getUser(), userDTO.getUser());
        Assertions.assertEquals(response.getToken(), userDTO.getToken());
        Mockito.verify(mockedCache).addToCache(TOKEN, response);
    }

    @Test
    public void checkAuthenticationFailureShouldThrowAuthenticationExceptionTest() {
        Assertions.assertThrows(AuthenticationException.class, () -> {
            this.sut.checkAuthentication(this.loginDTOFail);
        });
    }

}
