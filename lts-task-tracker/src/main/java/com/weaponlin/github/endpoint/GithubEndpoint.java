package com.weaponlin.github.endpoint;

import com.oneapm.touch.retrofit.boot.annotation.RetrofitService;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

@RetrofitService("github")
public interface GithubEndpoint {

    @GET("/users/byWeaponLin/{param}")
    Call<List<Object>> getGithubData(@Path("param") String param);
}
