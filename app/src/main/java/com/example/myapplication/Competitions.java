package com.example.myapplication;

import java.time.LocalDate;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListAdapters.CompetitionsAdapter;
import com.example.myapplication.ListClasses.ListCompetitions;

import java.util.ArrayList;
import java.util.List;

public class Competitions extends AppCompatActivity {

    RecyclerView CompetitionsListRecycler;

    CompetitionsAdapter CompetitionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_competitions);

        List<ListCompetitions> CompetitionsList = new ArrayList<>();
        CompetitionsList.add(new ListCompetitions(1, "Елисей", LocalDate.of(2027, 1, 22)));
        CompetitionsList.add(new ListCompetitions(2, "Олег",LocalDate.of(2027, 1, 22)));
        CompetitionsList.add(new ListCompetitions(3, "Дмитрий",LocalDate.of(2027, 1, 22)));
        CompetitionsList.add(new ListCompetitions(4, "Анна",LocalDate.of(2027, 1, 22)));

        setClientsListRecycler(CompetitionsList);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setClientsListRecycler(List<ListCompetitions> competitionsList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        CompetitionsListRecycler = findViewById(R.id.ClompetitionsList);
        CompetitionsListRecycler.setLayoutManager(layoutManager);

        CompetitionsAdapter = new CompetitionsAdapter(this, competitionsList);

        CompetitionsListRecycler.setAdapter(CompetitionsAdapter);

    }

    public void WorkoutBtnClick (View v){
        Intent intent = new Intent(this, Trainings.class);
        startActivity(intent);
    }

    public void ClientsBtnClick (View v){
        Intent intent = new Intent(this, Clients.class);
        startActivity(intent);
    }

    public void CompetBtnClick (View v){
        Intent intent = new Intent(this, Competitions.class);
        startActivity(intent);
    }

    public void ProfileBtnClick (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void CreateCompetition (View v){
        Intent intent = new Intent(this, CreateCompetition.class);
        startActivity(intent);
    }

}