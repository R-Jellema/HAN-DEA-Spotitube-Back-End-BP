package nl.han.oose.jellema.rick.services;

import nl.han.oose.jellema.rick.services.interfaces.ITokenDealer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.function.Supplier;

class TokenDealerTest {

    private String TOKEN = "5211e915-c3e2-4dcb-0776-c7b900f38ab7";
    private Supplier<UUID> mockedSupplier;
    private ITokenDealer sut;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        this.sut = new TokenDealer();
        this.mockedSupplier = Mockito.mock(Supplier.class);
        Field uuidField = this.sut.getClass().getDeclaredField("uuidSupplier");

        uuidField.setAccessible(true);
        uuidField.set(this.sut, mockedSupplier);

        Mockito.when(mockedSupplier.get()).thenReturn(UUID.fromString(TOKEN));
    }

    @Test
    void testAquireTokenShouldReturnUUIDToken() {
        String token = this.sut.aquireToken();
        Assertions.assertEquals(TOKEN, token);
    }
}