package com.weaponlin.github.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public interface RetrofitCallAdaptor {
    /**
     * Helper method to generate a real rest network request, use it as you wish
     *
     * @param retrofitCall the retrofit {@link Call} interface instance
     * @param <T>          the implicit type of response
     * @return the converted response if request success, otherwise the RetrofitRequestFailedException would be thrown
     */
    default <T> T execute(Call<T> retrofitCall) throws RuntimeException {
        try {
            Response<T> response = retrofitCall.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
            ResponseBody errorBody = response.errorBody();
            // Null would be present only if the request is successful. Add null check only to make sonar happy
            throw new RuntimeException(errorBody == null ? "请求失败" : errorBody.string());
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }
    }
}
