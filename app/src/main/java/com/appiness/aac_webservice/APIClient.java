package com.appiness.aac_webservice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClient {
    @GET("getappyandroidteam/")
    Call<ModelInfo> getEmpInfo();
}
