package com.droiddigger.lushan.retrofittest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mihodihasan on 7/13/17.
 */

public class ImageClass {
    @SerializedName("title")
    private String Title;
    @SerializedName("image")
    private String Image;
    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }
}
