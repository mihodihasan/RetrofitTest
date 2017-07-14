package com.droiddigger.lushan.retrofittest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GetTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_test);
    }

    public void getFruits(View view) {
        Intent intent=new Intent(this,GetListActivity.class);
        intent.putExtra("type","fruits");
        startActivity(intent);
    }

    public void getVeg(View view) {
        Intent intent=new Intent(this,GetListActivity.class);
        intent.putExtra("type","veg");
        startActivity(intent);
    }
}
