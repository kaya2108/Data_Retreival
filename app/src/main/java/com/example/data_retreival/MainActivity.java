package com.example.data_retreival;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private EditText regno;
    private Api api;
    private RecyclerView recyclerView;
    private TextView display1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.retrieve);
        regno=findViewById(R.id.regno);
        btn.setOnClickListener(this);
        recyclerView=findViewById(R.id.recycler);
        display1=findViewById(R.id.error);


    }

    @Override
    public void onClick(View v) {
        retrievePosts(regno.getText().toString());
    }

    private void retrievePosts(String regno) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://script.google.com/macros/s/AKfycbwnY2kITke1qGdbMO0_-1I0TcHQSWZmnEcU1I-1J4h2833YMd6RoBzPehxqPKR1yJZ1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(Api.class);
        Call<List<Model>> call=api.getPosts("get",regno);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> posts = response.body();
                for (Model post : posts) {
                    MyAdapter myAdapter = new MyAdapter(posts,MainActivity.this);
                    LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(myAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                display1.setText(t.getMessage());
            }
        });
    }
}