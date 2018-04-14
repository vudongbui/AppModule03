package com.example.owner.appmodule03;

/**
 * Created by Owner on 4/15/2018.
 */

public class Login {
    public class LoginRequest{
        public String username;
        public String password;

        public LoginRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public class LoginResponse{
        public boolean success;
    }
}
