package nl.han.oose.jellema.rick.data.database;

import nl.han.oose.jellema.rick.services.utils.PropertiesFiles;

import javax.inject.Inject;
import java.sql.*;
import java.util.Properties;

public class Database {

    private PropertiesFiles loadProperties;
    private Properties databaseProperties;
    private Connection connection;

    public Connection createConnection(String fileName){
            this.loadProperties = new PropertiesFiles();
            this.loadProperties.loadFile(fileName);
            this.databaseProperties = this.loadProperties.getPropertiesFile();
        try {
            Class.forName(this.databaseProperties.getProperty("driver"));
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }


        try {
            this.connection = DriverManager.getConnection(this.databaseProperties.getProperty("connectionString"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return this.connection;
    }

    public Connection getConnection(){
        return this.connection;
    }

    @Inject
    public void setPropertiesFiles(PropertiesFiles propertiesFiles){
        this.loadProperties = propertiesFiles;
    }

}
