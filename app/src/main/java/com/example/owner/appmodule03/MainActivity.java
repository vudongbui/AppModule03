package com.example.owner.appmodule03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create 1 retrofit
        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())  // Json-.Jav
                .baseUrl("https://qkserver1.herokuapp.com/api/")     // url của server
                .build();                                            //

        // tao obj req và trả về (response) (là Login.class)
        // tao interface khai bao request (là LoginService)
        // call
        final LoginService loginService = retrofit.create(LoginService.class);
        loginService.login(new Login().
                new LoginRequest("stu123","123"))
                .enqueue(new Callback<Login.LoginResponse>() {   //enqueue là tách việc gọi lên server ra luồng khác
            @Override
            public void onResponse(Call<Login.LoginResponse> call, Response<Login.LoginResponse> response) {
                //có mạng
                Log.d(TAG, "Login: " + response.body().success);
            }

            @Override
            public void onFailure(Call<Login.LoginResponse> call, Throwable t) {

                // không có mạng
            }
        });
    }
}
