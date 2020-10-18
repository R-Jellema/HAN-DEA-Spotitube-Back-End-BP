package nl.han.oose.jellema.rick.servicelayer.dto;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;


public class UserDTO {
    private String user;
    private String token;
    private String password;

    public UserDTO(String user, String token, String password) {
        this.user = user;
        this.token = token;
        this.password = password;
    }

    public UserDTO(){

    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
