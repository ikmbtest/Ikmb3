package com.test.ikmb3.giphy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmc on 21/3/17.
 */

public class GifList {

    @SerializedName("data")
    @Expose
    private List<GiphyGif> gifs = new ArrayList<>();

    public List<GiphyGif> getGifs() {
        return gifs;
    }

    public void setGifs(List<GiphyGif> gifs) {
        this.gifs = gifs;
    }

}
