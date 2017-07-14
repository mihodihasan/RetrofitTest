package com.droiddigger.lushan.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by mihodihasan on 7/13/17.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("upload.php")
    Call<ImageClass> uploadImage(@Field("title") String title,@Field("image") String image);

    @POST("readContacts.php")
    Call<List<Contact>> getContacts();

    @GET("getCalories.php")
    Call<List<Calories>> getCaloriesInfo(@Query("type") String type);
}
