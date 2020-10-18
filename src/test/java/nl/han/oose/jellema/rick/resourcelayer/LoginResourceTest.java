package nl.han.oose.jellema.rick.resourcelayer;

import nl.han.oose.jellema.rick.servicelayer.exceptions.AuthenticationException;

import nl.han.oose.jellema.rick.servicelayer.services.LoginService;
import nl.han.oose.jellema.rick.servicelayer.dto.UserDTO;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;


import javax.ws.rs.core.Response;

public class LoginResourceTest  {

    private LoginResource sut;
    private LoginService mockedSut;

    @BeforeEach
    private void setup(){
        this.sut = new LoginResource();
        this.mockedSut = Mockito.mock(LoginService.class);
        this.sut.setLoginService(mockedSut);

    }

    @Test
    public void loginShouldReturn200OKTest() throws AuthenticationException {
        // Arrange
        UserDTO loginDTO = new UserDTO();
        loginDTO.setUser("Rick");
        loginDTO.setPassword("12345");

        // Act
        Response response = this.sut.login(loginDTO);

        // Assert
        Assertions.assertEquals(200, response.getStatus());

    }

    @Test
    public void loginShouldFireUsedMethodsEvenThoughLoginIsIncorrectTest() throws AuthenticationException {
        UserDTO loginDTO = new UserDTO();
        loginDTO.setUser("Rick");
        loginDTO.setPassword("1245");

        // Act
        this.sut.login(loginDTO);

        // Assert
        Mockito.verify(mockedSut).checkAuthentication(loginDTO);
    }



}
