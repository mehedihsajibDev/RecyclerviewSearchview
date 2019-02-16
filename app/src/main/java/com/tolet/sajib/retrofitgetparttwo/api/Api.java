package com.tolet.sajib.retrofitgetparttwo.api;

import com.tolet.sajib.retrofitgetparttwo.modelclass.ModelTwo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
@GET("api/web/get-req-data/kitchen-filter")
    Call<List<ModelTwo>> getKitchen();
}
