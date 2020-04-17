package com.k2thend.gamesapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.k2thend.gamesapplication.R;
import com.k2thend.gamesapplication.model.DataGames;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyViewHolder> {
    List<DataGames> dataGamesList;

    public GamesAdapter(List<DataGames> dataGamesList){
        this.dataGamesList = dataGamesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_games, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataGames dataGames = dataGamesList.get(position);
        holder.homeTeam.setText(dataGames.getHomeTeam().getFullName());
        holder.awayTeam.setText(dataGames.getVisitorTeam().getFullName());


        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date format = dateFormat.parse(dataGames.getDate());
            holder.date.setText(dateFormat.format(format));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //holder.date.setText(datum.getDate());
        holder.time.setText(dataGames.getStatus());
        holder.abrevH.setText(dataGames.getHomeTeam().getAbbreviation());
        holder.abrevA.setText(dataGames.getVisitorTeam().getAbbreviation());
        holder.score.setText(dataGames.getHomeTeamScore()+ "-"+ dataGames.getVisitorTeamScore());

    }

    @Override
    public int getItemCount() {
        return dataGamesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeam, awayTeam, date, score, abrevH, abrevA, time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTeam = itemView.findViewById(R.id.team_a);
            awayTeam = itemView.findViewById(R.id.team_b);
            date = itemView.findViewById(R.id.date);
            score = itemView.findViewById(R.id.score);
            abrevH = itemView.findViewById(R.id.abry_team_a);
            abrevA = itemView.findViewById(R.id.abry_team_b);
            time = itemView.findViewById(R.id.time);
        }
    }
}
