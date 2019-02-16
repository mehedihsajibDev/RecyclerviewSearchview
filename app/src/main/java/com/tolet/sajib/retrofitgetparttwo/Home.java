package com.tolet.sajib.retrofitgetparttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tolet.sajib.retrofitgetparttwo.adapter.AdapterClass;
import com.tolet.sajib.retrofitgetparttwo.api.Api;
import com.tolet.sajib.retrofitgetparttwo.modelclass.ModelTwo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tolet.sajib.retrofitgetparttwo.R.id.searchEditText;

public class Home extends AppCompatActivity {
    RecyclerView recyclerView;
    private AdapterClass adapter;
    private ArrayList<ModelTwo> kitchenlist;
     SearchView searchView;
    String baseUrl = "http://apptitive.com/projects/web/foodpeon_api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // recyclerView = findViewById(R.id.recyclerviewid);

        setupRecyclerView();
        loadData();
        openSearchview();
    }




    private void loadData() {

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<ModelTwo>> call = api.getKitchen();
        call.enqueue(new Callback<List<ModelTwo>>() {
            @Override
            public void onResponse(Call<List<ModelTwo>> call, Response<List<ModelTwo>> response) {
//                kitchenlist = new ArrayList<>(response.body());
//                if (!kitchenlist.isEmpty()) {
//                    adapter = new AdapterClass(kitchenlist, getApplicationContext());
//                    recyclerView.setAdapter(adapter);
//                }
                kitchenlist = new ArrayList<>(response.body());
                if (!kitchenlist.isEmpty()) {
                    adapter = new AdapterClass(kitchenlist, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<ModelTwo>> call, Throwable t) {
                Toast.makeText(Home.this, "problem occured", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void openSearchview() {
        searchView = (SearchView) findViewById(searchEditText);
   searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
       @Override
       public boolean onQueryTextSubmit(String query) {
           if (adapter != null) adapter.getFilter().filter(query);
           return true;
       }

       @Override
       public boolean onQueryTextChange(String newText) {
           if (adapter != null) adapter.getFilter().filter(newText);
           return true;
       }
   });
   searchView.setOnCloseListener(new SearchView.OnCloseListener() {
       @Override
       public boolean onClose() {
           return true;
       }
   });
    }


    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerviewid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
