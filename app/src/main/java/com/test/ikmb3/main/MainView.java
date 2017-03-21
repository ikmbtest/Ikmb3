package com.test.ikmb3.main;

import com.test.ikmb3.giphy.GifList;

/**
 * Created by mmc on 21/3/17.
 */

public interface MainView {

    void setGifs(GifList list);
    void showError(String error);

}
