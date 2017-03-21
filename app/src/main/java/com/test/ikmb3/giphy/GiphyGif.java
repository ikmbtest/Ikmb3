package com.test.ikmb3.giphy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mmc on 21/3/17.
 */

public class GiphyGif {

    @SerializedName("images")
    @Expose
    private Images images;

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
