package com.example.owner.appmodule03;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Owner on 4/12/2018.
 */

public interface RegisterService {
    @POST("register")
    Call<Register.RegisterResponse> register(@Body Register.RegisterRequest registerRequest);

}
