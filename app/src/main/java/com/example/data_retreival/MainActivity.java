package com.example.data_retreival;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button summary1,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.retrieve);
        regno=findViewById(R.id.regno);
        btn.setOnClickListener(this);
        recyclerView=findViewById(R.id.recycler);
        display1=findViewById(R.id.error);
        summary1=findViewById(R.id.summary1);
        summary1.setOnClickListener(this);
        delete=findViewById(R.id.delete);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.retrieve:
                retrievePosts(regno.getText().toString());
                break;
            case R.id.summary1:
                retrieveSummary();
            case R.id.delete:
                deleteData();
        }

    }

    private void deleteData() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://script.google.com/macros/s/AKfycby3i9g_jJrbYTnteKqLO_TPo9PmFqOExt03uuc5cvfR-_lUMCrBL4jY4s4yftjdOezp/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(Api.class);
        Call<Delete> call=api.deletePost("delete","MTNlMzRlMWQtMWRjOS00ODViLWI3YjktODRjNWRkZmVhODgy");
        call.enqueue(new Callback<Delete>() {
            @Override
            public void onResponse(Call<Delete> call, Response<Delete> response) {
                Delete posts=response.body();
                String uniqueID= posts.getUniqueID();
                Toast.makeText(MainActivity.this,uniqueID+" Deleted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Delete> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void retrieveSummary() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://script.google.com/macros/s/AKfycbxXrwratYektLHculapSofI9BC7yWCUr1OejUOxaVecT7gDVZRnXoIjQviD8-Dj-FWS/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(Api.class);
        Call<summary> call=api.getSummary("getCount");
        call.enqueue(new Callback<summary>() {
            @Override
            public void onResponse(Call<summary> call, Response<summary> response) {
                summary posts = response.body();
                String content="";
                content+="XS: "+posts.getXs()+"\n";
                content+="S: "+posts.getS()+"\n";
                content+="M: "+posts.getM()+"\n";
                content+="L: "+posts.getL()+"\n";
                content+="XL: "+posts.getXl()+"\n";
                content+="XXL: "+posts.getXxl()+"\n";
                content+="XXXL: "+posts.getXxxl()+"\n";
                display1.append(content);


            }

            @Override
            public void onFailure(Call<summary> call, Throwable t) {

            }
        });
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