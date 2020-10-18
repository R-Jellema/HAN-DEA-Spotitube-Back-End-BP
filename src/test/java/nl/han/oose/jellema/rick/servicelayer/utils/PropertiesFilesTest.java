package nl.han.oose.jellema.rick.servicelayer.utils;


import nl.han.oose.jellema.rick.servicelayer.exceptions.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;


import static org.junit.jupiter.api.Assertions.*;


class PropertiesFilesTest {

    PropertiesFiles properties;
    Properties file;
    @BeforeEach
    public void setup() {
        this.properties = new PropertiesFiles();
        this.properties.loadFile("database.properties");
        this.file = this.properties.getPropertiesFile();

    }

    @Test
    public void getPropertiesFileShouldReturnPropertiesFile() {
        var response = this.properties.getPropertiesFile();
        assertEquals(this.file, response);
    }

    @Test
    public void loadingFileAsInputStreamFailShouldThrowFileNotFoundException(){
        assertThrows(FileNotFoundException.class, () -> this.properties.loadFile("database"));
    }






}
