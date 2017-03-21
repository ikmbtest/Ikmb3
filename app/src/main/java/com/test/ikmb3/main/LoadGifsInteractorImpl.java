package com.test.ikmb3.main;

import com.test.ikmb3.Utils.ApiService;
import com.test.ikmb3.Utils.RetroClient;
import com.test.ikmb3.giphy.GifList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mmc on 21/3/17.
 */

public class LoadGifsInteractorImpl implements LoadGifsInteractor {


    @Override
    public void loadGifs(final OnFinishedListener onFinishedListener) {
        ApiService api = RetroClient.getApiService(RetroClient.ROOT_URL_GIPHY);

        Call<GifList> gifListCall = api.getJsonGifs("20", ApiService.API_KEY_TESTING);

        gifListCall.enqueue(new Callback<GifList>() {
            @Override
            public void onResponse(Call<GifList> call, Response<GifList> response) {
                if (response.isSuccessful()) {
                    GifList list = response.body();
                    onFinishedListener.onFinished(list);
                } else {
                    onFinishedListener.onFinishedError("Error");
                }
            }

            @Override
            public void onFailure(Call<GifList> call, Throwable t) {
                onFinishedListener.onFinishedError("Error");
            }
        });
    }
}
