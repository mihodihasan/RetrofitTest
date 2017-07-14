package com.droiddigger.lushan.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CaloriesAdapter caloriesAdapter;
    List<Calories> calories;
    RecyclerView.LayoutManager layoutManager;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_list);

        recyclerView=(RecyclerView)findViewById(R.id.GETListRecyclerView);
        layoutManager=new LinearLayoutManager(this);
        calories=new ArrayList<>();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        if (getIntent().getExtras()!=null){
            String type=getIntent().getStringExtra("type");
            Log.d("hereisthetype",type);
            fetchInformation(type);
        }
    }

    private void fetchInformation(String type) {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Calories>> call=apiInterface.getCaloriesInfo(type);

        call.enqueue(new Callback<List<Calories>>() {
            @Override
            public void onResponse(Call<List<Calories>> call, Response<List<Calories>> response) {
                calories=response.body();
                caloriesAdapter=new CaloriesAdapter(GetListActivity.this,calories);
                recyclerView.setAdapter(caloriesAdapter);
                Toast.makeText(GetListActivity.this, "Huhahah", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Calories>> call, Throwable t) {
                Toast.makeText(GetListActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
