package nl.han.oose.jellema.rick.datalayer;

import nl.han.oose.jellema.rick.datalayer.Database;
import nl.han.oose.jellema.rick.servicelayer.utils.PropertiesFiles;
import nl.han.oose.jellema.rick.servicelayer.exceptions.FileNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;

class DatabaseTest {

    private Database sut;
    private PropertiesFiles mockedProperties;

    @BeforeEach
    void setup()  {
        this.sut = new Database();
        this.mockedProperties = Mockito.mock(PropertiesFiles.class);
        this.sut.setPropertiesFiles(this.mockedProperties);
    }


    @Test
    void getConnectionShouldReturnConnection() {
        Connection expectedConnection = this.sut.createConnection("database.properties");
        Assertions.assertEquals(expectedConnection, this.sut.getConnection());
    }

    @Test
    void loadingPropertiesFailShouldFileNotFoundException() {
        Assertions.assertThrows(FileNotFoundException.class, () -> { new Database().createConnection("Test");});
    }

}