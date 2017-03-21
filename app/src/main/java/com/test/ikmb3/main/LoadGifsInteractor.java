package com.test.ikmb3.main;

import com.test.ikmb3.giphy.GifList;

/**
 * Created by mmc on 21/3/17.
 */

public interface LoadGifsInteractor {

    interface OnFinishedListener {
        void onFinished(GifList gifs);
        void onFinishedError(String error);
    }

    void loadGifs(OnFinishedListener onFinishedListener);


}
