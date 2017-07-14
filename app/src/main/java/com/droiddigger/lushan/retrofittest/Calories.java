package com.droiddigger.lushan.retrofittest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mihodihasan on 7/13/17.
 */

public class Calories {
    @SerializedName("name")
    private String name;
    @SerializedName("image_path")
    private String imagePath;
    @SerializedName("cal")
    private String calory;

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getCalory() {
        return calory;
    }
}
