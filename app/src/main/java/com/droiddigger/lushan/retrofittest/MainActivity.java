package com.droiddigger.lushan.retrofittest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Image_Title;
    Button chooseBtn, uploadBtn;
    ImageView imageView;
    private static final int IMG_REQUEST = 1;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Image_Title = (EditText) findViewById(R.id.img_title);
        chooseBtn = (Button) findViewById(R.id.chooseBtn);
        uploadBtn = (Button) findViewById(R.id.uploadBtn);
        imageView = (ImageView) findViewById(R.id.imageView);
//        imgV=(ImageView)findViewById(R.id.imgV);
//        Glide.with(getBaseContext()).load("http://10.0.2.2/shop/image/catalog/products/Card set/609A6647.png").into(imgV);
        chooseBtn.setOnClickListener(this);
        uploadBtn.setOnClickListener(this);

    }

    public void fetch(View view) {
        startActivity(new Intent(this, FetchData.class));
    }

    public void get(View view) {
        startActivity(new Intent(this, GetTest.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chooseBtn:
                selectImage();
                break;
            case R.id.uploadBtn:
                uploadImage();
                break;

        }
    }

    public void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == IMG_REQUEST && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
                Image_Title.setVisibility(View.VISIBLE);
                chooseBtn.setEnabled(false);
                uploadBtn.setEnabled(true);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Image Select Failed!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

    public void uploadImage() {
        String image = imageToString();
        String title = Image_Title.getText().toString();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<ImageClass> call = apiInterface.uploadImage(title, image);

        call.enqueue(new Callback<ImageClass>() {
            @Override
            public void onResponse(Call<ImageClass> call, Response<ImageClass> response) {
                ImageClass imageClass = response.body();
                Toast.makeText(MainActivity.this, "Server Response: " + imageClass.getResponse(), Toast.LENGTH_SHORT).show();
                Log.e("errormsg","Server Response: " + imageClass.getResponse());
            }

            @Override
            public void onFailure(Call<ImageClass> call, Throwable t) {

            }
        });
    }
}
