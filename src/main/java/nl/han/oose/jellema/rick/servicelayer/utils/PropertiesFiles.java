package nl.han.oose.jellema.rick.servicelayer.utils;
import nl.han.oose.jellema.rick.servicelayer.exceptions.FileNotFoundException;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFiles {

    private String propertiesFileName = "";
    private java.util.Properties propertiesFile;

    public void loadFile(String fileName){
        this.propertiesFile = new Properties();
        this.propertiesFileName = fileName;
        InputStream temp = getClass().getClassLoader().getResourceAsStream(this.propertiesFileName);
        if(temp == null) throw new FileNotFoundException();
            try {
                this.propertiesFile.load(temp);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public Properties getPropertiesFile(){
        return this.propertiesFile;
    }


}
