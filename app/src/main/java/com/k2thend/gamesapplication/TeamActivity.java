package com.k2thend.gamesapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.k2thend.gamesapplication.adapter.ItemClickTeam;
import com.k2thend.gamesapplication.adapter.TeamAdapter;
import com.k2thend.gamesapplication.model.DataTeam;
import com.k2thend.gamesapplication.model.TeamsResponse;
import com.k2thend.gamesapplication.retrofit.ApiInterface;
import com.k2thend.gamesapplication.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamActivity extends AppCompatActivity implements ItemClickTeam {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        recyclerView = findViewById(R.id.recyclerTeam);

        ApiService.getRetrofit().create(ApiInterface.class)
                .getTeams()
                .enqueue(new Callback<TeamsResponse>() {
                    @Override
                    public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                        Log.e("TAG", "onResponse: " );
                        if (response.isSuccessful()){
                            if(response.body().getDataTeams() != null){

                                Log.e("LIST SIZE", "LIST SIZE" + response.body().getDataTeams().size());

                                TeamAdapter teamAdapter = new TeamAdapter(response.body().getDataTeams());
                                teamAdapter.setClickTeam(TeamActivity.this);
                                recyclerView.setLayoutManager( new LinearLayoutManager(TeamActivity.this));
                                DividerItemDecoration itemDecoration = new DividerItemDecoration(TeamActivity.this, DividerItemDecoration.VERTICAL);
                                recyclerView.setAdapter(teamAdapter);
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<TeamsResponse> call, Throwable t) {
                        Log.e("throw", t.getMessage());
                    }
                });
    }

    @Override
    public void itemClickTeam(DataTeam team, int id) {
        Snackbar.make(recyclerView, team.getCity(), Snackbar.LENGTH_LONG).show();
    }
}
