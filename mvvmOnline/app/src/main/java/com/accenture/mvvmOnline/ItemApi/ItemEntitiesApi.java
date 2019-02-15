package com.accenture.mvvmOnline.ItemApi;


import com.accenture.mvvmOnline.model.ItemEntities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItemEntitiesApi {

    @GET("data/{kinds}/{num}/{page}")
    Call<ItemEntities> query(@Path("kinds") String kinds, @Path("num") int num, @Path("page") int page);
}
