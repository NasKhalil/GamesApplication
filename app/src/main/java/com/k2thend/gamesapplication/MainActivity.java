package com.k2thend.gamesapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.k2thend.gamesapplication.adapter.GamesAdapter;
import com.k2thend.gamesapplication.model.ApiResponse;
import com.k2thend.gamesapplication.retrofit.ApiInterface;
import com.k2thend.gamesapplication.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Button teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        // async
        // redéfinition de la methode getGames
        ApiService.getRetrofit().create(ApiInterface.class)
                .getGames()
                .enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                        if (response.body().getData() != null){
                            GamesAdapter adapter = new GamesAdapter(response.body().getData());
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            // dividerItemdecoration ligne entre les lignes
                            DividerItemDecoration itemDecoration =
                                    new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
                            recyclerView.addItemDecoration(itemDecoration);
                            recyclerView.setAdapter(adapter);
                        }

 //test
//                        if (response.body() != null)
//                            Log.e("LIST SIZE", "LIST SIZE" + response.body().getData().size());
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Log.e("ERROR", "ERROR" + t);
                    }
                });


        teams = findViewById(R.id.buttonEquipe);
        teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TeamActivity.class);
                startActivity(intent);
            }
        });


    }
}
