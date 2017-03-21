package com.test.ikmb3.Utils;

import com.test.ikmb3.giphy.GifList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mmc on 19/3/17.
 */

public interface ApiService {

    String API_KEY_TESTING = "dc6zaTOxFJmzC";
    String API_KEY_FINAL = ""; //TODO Pending for the release version

    @GET("v1/gifs/trending?")
    Call<GifList> getJsonGifs(@Query("limit") String limit, @Query("api_key") String key);

}