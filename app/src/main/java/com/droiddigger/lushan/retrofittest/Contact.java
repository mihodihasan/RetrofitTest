package com.droiddigger.lushan.retrofittest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mihodihasan on 7/13/17.
 */

public class Contact {
    @SerializedName("name")
    private String Name;
    @SerializedName("email")
    private String Email;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
}
