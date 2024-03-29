package nl.han.oose.jellema.rick.servicelayer;

import nl.han.oose.jellema.rick.servicelayer.exceptions.InvalidTokenException;
import nl.han.oose.jellema.rick.servicelayer.dto.UserDTO;
import nl.han.oose.jellema.rick.resourcelayer.ICache;
import nl.han.oose.jellema.rick.servicelayer.services.Cache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CacheTest {
    private ICache sut;
    private final String TOKEN = "TestToken";
    private final UserDTO dto = new UserDTO("Rick", TOKEN, null);

    @BeforeEach
    void setUp() {
        this.sut = new Cache();

    }

    @Test
    void addToCacheShouldAddUserToCache() {
        this.sut.addToCache(TOKEN, dto);

        var response = this.sut.getUser(TOKEN);
        Assertions.assertEquals(response, dto);
    }

    @Test
    void getUserShouldThrowInvalidTokenExceptionIfNoUserFoundTest() {
        Assertions.assertThrows(InvalidTokenException.class, () -> {this.sut.getUser(TOKEN);});
    }

    @Test
    void getUserShouldReturnUserTest(){
        UserDTO dto = new UserDTO("Rick", TOKEN, null);
        this.sut.addToCache(TOKEN, dto);

        var response = this.sut.getUser(TOKEN);
        Assertions.assertEquals(response, dto);
    }

    @Test
    void userExistsShouldThrowInvalidtokenExceptionIfNoUserFoundTest() {
        Assertions.assertThrows(InvalidTokenException.class, () -> {this.sut.getUser(TOKEN);});
    }
    @Test
    void userExistsShouldReturnTrue() {
        UserDTO dto = new UserDTO("Rick", TOKEN, null);
        this.sut.addToCache(TOKEN, dto);

        var response = this.sut.userExists(TOKEN);
        Assertions.assertTrue(response);
    }
}