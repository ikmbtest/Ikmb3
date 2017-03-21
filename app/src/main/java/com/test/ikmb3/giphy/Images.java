package com.test.ikmb3.giphy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mmc on 21/3/17.
 */

public class Images {

    @SerializedName("original")
    @Expose
    private Original original;

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }
}
